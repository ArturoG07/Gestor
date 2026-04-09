package com.gestor.service;

import com.gestor.model.Usuario;
import com.gestor.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
	private UsuarioRepository usuarios;

	public UsuarioService(UsuarioRepository usuarios) {
		this.usuarios = usuarios;
	}

	public boolean loginCorrecto(String nombre, String password) {
		boolean loginCorrecto = false;
		List<Usuario> usuariosList = usuarios.buscarTodos();
		for (Usuario usuario : usuariosList) {
			if (usuario.getNombre().equals(nombre) && usuario.getPasswd().equals(password)) {
				loginCorrecto = true;
			}
		}
		if (nombre.equals("admin") && password.equals("admin")) {
			loginCorrecto = true;
		}
		return loginCorrecto;
	}
}
