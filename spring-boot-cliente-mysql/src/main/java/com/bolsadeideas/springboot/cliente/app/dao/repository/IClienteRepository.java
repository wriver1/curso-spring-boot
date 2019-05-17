package com.bolsadeideas.springboot.cliente.app.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.cliente.app.dao.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
