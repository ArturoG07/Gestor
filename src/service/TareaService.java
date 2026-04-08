package service;

import repository.TareaRepository;
import repository.UsuarioRepository;

public class TareaService {
	private TareaRepository tareas;
	private UsuarioRepository usuarios;

	public TareaService(TareaRepository tareas, UsuarioRepository usuarios) {
		this.tareas = tareas;
		this.usuarios = usuarios;
	}
}
