package com.gestor.service;

import com.gestor.model.Usuario;
import com.gestor.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private static int contador = 1;
	private UsuarioRepository usuarios;

	public UsuarioService(UsuarioRepository usuarios) {
		this.usuarios = usuarios;
	}

}
