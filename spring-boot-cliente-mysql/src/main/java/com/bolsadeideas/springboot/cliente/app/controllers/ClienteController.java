package com.bolsadeideas.springboot.cliente.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.cliente.app.dao.entities.Cliente;
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
	
	@GetMapping("/delete/{id}")
	public String eliminarCliente(@PathVariable(name = "id") Long id) {
		clienteService.delete(id);
		return "redirect:/cliente/home";
	}
	
	@GetMapping("/form")
	public String formulario(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}
	
	
	@RequestMapping(value="/editar/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findById(id);
		} else {
			return "redirect:/home";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:home";
	}
}
