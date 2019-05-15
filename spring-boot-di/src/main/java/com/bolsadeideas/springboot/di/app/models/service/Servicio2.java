package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

@Service("servicio2")
public class Servicio2 implements IServicio {

	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "Retornando desde el servicio 2 llamado por qualifer";
	}

}
