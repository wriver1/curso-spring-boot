package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
public class IndexController {

	@GetMapping({"/","/index", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenidos a Spring boot");
		return "index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listar usuarios");
		return "listar";
	}
	
	/*Esta es una forma de compartir un atributo a todo el controlador
	 * Se anota el método con @ModelAttribute y se le asigna un valor
	 * y con esto el atributo queda disponible a todo el controlador*/
	@ModelAttribute("usuarios")
	public List<Usuario> cargarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Wilson", "Rivera", "Wilson@correo.com"), new Usuario("Leidy", "Contreras", "lcontreras@correo.com"), new Usuario("Martin", "Rivera", "mrivera@correo.com"));
		return usuarios;
	}
}
