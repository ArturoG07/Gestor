package com.gestor.service;

import com.gestor.model.Tarea;
import com.gestor.model.TareaDTO;
import com.gestor.repository.TareaRepository;
import com.gestor.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
	private TareaRepository tareas;
	private UsuarioRepository usuarios;

	public TareaService(TareaRepository tareas, UsuarioRepository usuarios) {
		this.tareas = tareas;
		this.usuarios = usuarios;
	}

	public List<Tarea> getAllTareas() {
		return tareas.buscarTodos();
	}
	public List<Tarea> getTareasUsuario(int idUsuario) {
		return tareas.buscarTareasUsuario(idUsuario);
	}

	public void crearTarea(TareaDTO tarea, int idUsuario) {
		tareas.guardar(tarea, idUsuario);
	}

	public Tarea updateTarea(Tarea tarea) {
		// Assuming update means replace if exists
		if (tareas.existeId(tarea.getId())) {
			tareas.eliminarPorId(tarea.getId());
			tareas.save(tarea);
		}
		return tarea;
	}

	public void deleteTarea(int id) {
		tareas.eliminarPorId(id);
	}
}
