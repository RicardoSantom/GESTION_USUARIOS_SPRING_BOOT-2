package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.service.ServicioUsuario;

@Controller
@RequestMapping("/usuario")
public class ControladorUsuario {
	// @Autowired
	private ServicioUsuario servicioUsuario;
	
	

	/**
	 * Maneja la solicitud GET "/editar" para editar un usuario.
	 *
	 * @param modelo El objeto Model para agregar atributos.
	 * @param id     El ID del usuario a editar.
	 * @param sesion La sesión HTTP.
	 * @return La vista "usuarios/crearUsuario" para editar el usuario.
	 */
	@GetMapping("editar")
	public String editarUsuario(Model modelo, @RequestParam int id, HttpSession sesion) {
		modelo.addAttribute("usuario", servicioUsuario.getUsuarioByID(id));
		return "/usuarios/crearUsuario";
	}

	/**
	 * Maneja la solicitud GET "/cancelar" para cancelar una operación.
	 *
	 * @return La vista "index" para redirigir al inicio.
	 */
	@GetMapping("cancelar")
	public String cancelar() {
		return "index";
	}

	/**
	 * Maneja la solicitud POST "/filtrarPorRol" para filtrar usuarios por rol.
	 *
	 * @param modelo El objeto Model para agregar atributos.
	 * @param rol    El ID del rol para filtrar usuarios.
	 * @param sesion La sesión HTTP.
	 * @return La vista de listado de usuarios.
	 */
	@PostMapping("filtrarPorRol")
	public String filtrarPorRol(Model modelo, @RequestParam int rol, HttpSession sesion) {
		modelo.addAttribute("rol", rol);
		return listarUsuarios(modelo, sesion);
	}

	/**
	 * Maneja la solicitud GET "/baja" para dar de baja a un usuario.
	 *
	 * @param modelo El objeto Model para agregar atributos.
	 * @param id     El ID del usuario a dar de baja.
	 * @return Redirige a la vista de listado de usuarios.
	 */
	@GetMapping("baja")
	public String baja(Model modelo, @RequestParam int id) {
		servicioUsuario.darBajaUsuario(id);
		return "redirect:listar";
	}

	/**
	 * Maneja la solicitud GET "/alta" para dar de alta a un usuario.
	 *
	 * @param modelo El objeto Model para agregar atributos.
	 * @param id     El ID del usuario a dar de alta.
	 * @return Redirige a la vista de listado de usuarios.
	 */
	@GetMapping("alta")
	public String alta(Model modelo, @RequestParam int id) {
		servicioUsuario.darAltaUsuario(id);
		return "redirect:listar";
	}

	// Método privado para listar usuarios
	private String listarUsuarios(Model modelo, HttpSession sesion) {
		// TODO: Implementar lógica para listar usuarios
		return null;
	}
}
