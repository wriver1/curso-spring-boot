package com.bolsadeideas.springboot.cliente.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.cliente.app.services.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping({"/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Clientes Registrados");
		model.addAttribute("clientes", clienteService.findAll());
		return "home";
	}
}
