package controller;

import service.UsuarioService;

public class UsuarioController {
	private UsuarioService usuarios;

	public UsuarioController(UsuarioService usuarios) {
		this.usuarios = usuarios;
	}
}
