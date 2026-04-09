package com.gestor.service;

import com.gestor.model.Tarea;
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

	public Tarea getTareaById(int id) {
		return tareas.buscarPorId(id);
	}

	public Tarea createTarea(Tarea tarea) {
		// Generate id if not set
		if (tarea.getId() == 0) {
			int maxId = tareas.buscarTodos().stream().mapToInt(Tarea::getId).max().orElse(0);
			tarea.setId(maxId + 1);
		}
		tareas.save(tarea);
		return tarea;
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
