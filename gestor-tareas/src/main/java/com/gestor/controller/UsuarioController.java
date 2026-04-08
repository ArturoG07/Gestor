package com.gestor.controller;

import com.gestor.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioController {
	private UsuarioService usuarios;

	public UsuarioController(UsuarioService usuarios) {
		this.usuarios = usuarios;
	}
}
