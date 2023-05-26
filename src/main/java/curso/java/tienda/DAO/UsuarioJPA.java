package curso.java.tienda.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.java.tienda.modelo.Usuario;

public interface UsuarioJPA extends JpaRepository<Usuario, Integer>{
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Usuario findById(int id);
	
	  /**
     * Método que busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra ningún usuario con ese correo electrónico.
     */
    Usuario findByEmail(String email);

    /**
     * Método que busca una lista de usuarios por su rol.
     *
     * @param rol El identificador del rol de los usuarios a buscar.
     * @return Una lista de usuarios que tienen el rol especificado.
     */
    List<Usuario> findByRol(int rol);
}
