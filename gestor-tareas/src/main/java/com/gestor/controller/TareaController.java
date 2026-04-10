package com.gestor.controller;

import com.gestor.model.Tarea;
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
}
