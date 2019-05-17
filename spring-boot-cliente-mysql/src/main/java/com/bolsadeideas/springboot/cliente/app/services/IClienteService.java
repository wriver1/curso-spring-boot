package com.bolsadeideas.springboot.cliente.app.services;

import java.util.List;

import com.bolsadeideas.springboot.cliente.app.dao.entities.Cliente;

public interface IClienteService {

	public Cliente findById(Long id);
	
	public void save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Cliente> findAll();
}
