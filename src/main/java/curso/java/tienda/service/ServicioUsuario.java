package curso.java.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jasypt.util.password.StrongPasswordEncryptor;

import curso.java.tienda.DAO.UsuarioJPA;
import curso.java.tienda.modelo.Usuario;

@Service
public class ServicioUsuario {
	 @Autowired
	    private UsuarioJPA usuarioDAO;

	    /**
	     * Agrega un usuario.
	     *
	     * @param usuario El usuario a agregar.
	     */
	    public void addUsuario(Usuario usuario) {
	        usuario.setClave(encriptarPassword(usuario.getClave()));
	        usuarioDAO.save(usuario);
	    }

	    /**
	     * Obtiene un usuario por su ID.
	     *
	     * @param id El ID del usuario.
	     * @return El usuario encontrado.
	     */
	    public Usuario getUsuarioByID(int id) {
	        return usuarioDAO.findById(id);
	    }

	    /**
	     * Busca un usuario por su dirección de correo electrónico.
	     *
	     * @param email La dirección de correo electrónico del usuario.
	     * @return El usuario encontrado.
	     */
	    public Usuario findByEmail(String email) {
	        return usuarioDAO.findByEmail(email);
	    }

	    /**
	     * Comprueba los datos de inicio de sesión de un usuario.
	     *
	     * @param mail     La dirección de correo electrónico del usuario.
	     * @param password La contraseña del usuario.
	     * @return El usuario si los datos son válidos, o null si no lo son.
	     */
	    public Usuario comprobarDatos(String mail, String password) {
	        Usuario u = null;
	        Usuario u2 = usuarioDAO.findByEmail(mail);
			System.out.println(u2.getEmail()+u2.getClave());
	        if (u2 != null && comprobarPasswordLogin(u2.getClave(), password) && !u2.isBaja()) {
	            u = u2;
	        }
	        return u;
	    }

	    /**
	     * Encripta una contraseña utilizando el algoritmo StrongPasswordEncryptor.
	     *
	     * @param password La contraseña a encriptar.
	     * @return La contraseña encriptada.
	     */
	    public String encriptarPassword(String password) {
	        StrongPasswordEncryptor encriptador = new StrongPasswordEncryptor();
	        String encryptedPassword = encriptador.encryptPassword(password);

	        return encryptedPassword;
	    }

	    /**
	     * Comprueba si una contraseña es válida comparándola con una contraseña encriptada.
	     *
	     * @param passwordCod La contraseña encriptada.
	     * @param password    La contraseña a comprobar.
	     * @return true si la contraseña es válida, false de lo contrario.
	     */
	    private boolean comprobarPasswordLogin(String passwordCod, String password) {
	        StrongPasswordEncryptor encriptador = new StrongPasswordEncryptor();
	        return encriptador.checkPassword(password, passwordCod);
	    }

	    /**
	     * Cambia la contraseña de un usuario.
	     *
	     * @param email    La dirección de correo electrónico del usuario.
	     * @param password La nueva contraseña.
	     */
	    public void cambiarPassword(String email, String password) {
	        Usuario user = usuarioDAO.findByEmail(email);
	        if (user != null) {
	            user.setClave(encriptarPassword(password));
	            usuarioDAO.save(user);
	        }
	    }
	//
//	    /**
//	     * Obtiene un rol por su ID.
//	     *
//	     * @param id El ID del rol.
//	     * @return El rol encontrado.
//	     */
//	    public int getRol(int id) {
//	        return rJPA.getById(id);
//	    }

	    

	    /**
	     * Lista todos los usuarios.
	     *
	     * @return La lista de usuarios.
	     */
	    public List<Usuario> listarUsuarios() {
	        return usuarioDAO.findAll();
	    }

	    /**
	     * Lista los usuarios por rol.
	     *
	     * @param rol El ID del rol.
	     * @return La lista de usuarios que tienen el rol especificado.
	     */
	    public List<Usuario> listarUsuariosPorRol(int rol) {
	        return usuarioDAO.findByRol(rol);
	    }

	    /**
	     * Da de baja a un usuario.
	     *
	     * @param id El ID del usuario.
	     */
	    public void darBajaUsuario(int id) {
	        Usuario usuario = usuarioDAO.getById(id);
	        usuario.setBaja(true);
	        usuarioDAO.save(usuario);
	    }

	    /**
	     * Da de alta a un usuario.
	     *
	     * @param id El ID del usuario.
	     */
	    public void darAltaUsuario(int id) {
	        Usuario usuario = usuarioDAO.getById(id);
	        usuario.setBaja(false);
	        usuarioDAO.save(usuario);
	    }
}
