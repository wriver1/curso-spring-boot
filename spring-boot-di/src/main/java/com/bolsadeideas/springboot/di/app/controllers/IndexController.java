package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	/**Usar interfaces para hacer inyección de dependencias permite desacoplar los componentes
	 * además hace que sea más genérico. Aquí por ejemplo estamos inyectando 2 servicios que
	 * implementan la misma interface y se hace inyectando la interfcae IService pero se diferencian
	 * por la anotación @Qualifier asignando el nombre que corresponde a los componentes anotados
	 * como @Service. @see MiServicio, Servicio2 */
	@Autowired
	@Qualifier("servicio1")
	private IServicio  servicio1;
	
	@Autowired
	@Qualifier("servicio2")
	private IServicio  servicio2;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("servicio1", servicio1.operacion());
		model.addAttribute("servicio2", servicio2.operacion());
		return "index";
	}
}
