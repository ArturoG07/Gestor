package com.gestor.service;

import com.gestor.repository.TareaRepository;
import com.gestor.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
	private TareaRepository tareas;
	private UsuarioRepository usuarios;

	public TareaService(TareaRepository tareas, UsuarioRepository usuarios) {
		this.tareas = tareas;
		this.usuarios = usuarios;
	}
}
