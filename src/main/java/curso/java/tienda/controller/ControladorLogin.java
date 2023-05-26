package curso.java.tienda.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.modelo.Usuario;
import curso.java.tienda.service.ServicioUsuario;

@Controller
@RequestMapping
public class ControladorLogin {
	@Autowired
	private ServicioUsuario servicioUsuario;
	@GetMapping("")
	public String login(Model modelo,HttpSession sesion) {
		
		modelo.addAttribute("usuario",new Usuario());
		return "login";
	}
	@PostMapping("")
	public String comprobarLogin(HttpSession sesion,@ModelAttribute(name = "usuario") Usuario usuario) {
		Usuario comprobacion=servicioUsuario.comprobarDatos(usuario.getEmail().toString(),usuario.getClave());
		if(comprobacion!=null) {
			sesion.setAttribute("usuario", comprobacion);
		}
		if(comprobacion!=null) {
			sesion.setAttribute("usuario", comprobacion);
			return "redirect:index";
		}else {
			return "redirect:";
		}
//		su.addUsuario(usuario,1);
//		System.out.println(usuario.toString());
//		return "login";
	}
	@GetMapping("logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.removeAttribute("usuario");
		return "redirect:";
	}
	@GetMapping("index")
	public String index(Model modelo) {
		modelo.addAttribute("usuarios", servicioUsuario.listarUsuarios());
		return "index";
	}
}
