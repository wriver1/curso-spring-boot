package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

@Service("servicio1")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecuntando un proceso";
	}
}
