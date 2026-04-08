package service;

import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
	private static int contador = 1;
	private UsuarioRepository usuarios;

	public UsuarioService(UsuarioRepository usuarios) {
		this.usuarios = usuarios;
	}

}
