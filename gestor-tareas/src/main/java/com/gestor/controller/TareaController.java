package com.gestor.controller;

import com.gestor.model.Tarea;
import com.gestor.model.TareaDTO;
import com.gestor.model.UsuarioLoginDTO;
import com.gestor.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
	private TareaService tareaService;

	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}

	@GetMapping("/cargarTareas")
	public List<Tarea> getTareas(@RequestParam int id) {
		return tareaService.getTareasUsuario(id);
	}

	@PostMapping("/anadir")
	public void crearTarea(@RequestBody TareaDTO tarea) {
		int idUsuario = 1; //TODO: asignar el id correcto de usuario cuando haya session con tokens
		tareaService.crearTarea(tarea, idUsuario);
	}
}
