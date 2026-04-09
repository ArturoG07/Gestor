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

	@GetMapping
	public List<Tarea> getAllTareas() {
		return tareaService.getAllTareas();
	}

	@GetMapping("/{id}")
	public Tarea getTareaById(@PathVariable int id) {
		return tareaService.getTareaById(id);
	}

	@PostMapping
	public Tarea createTarea(@RequestBody Tarea tarea) {
		return tareaService.createTarea(tarea);
	}

	@PutMapping("/{id}")
	public Tarea updateTarea(@PathVariable int id, @RequestBody Tarea tarea) {
		tarea.setId(id);
		return tareaService.updateTarea(tarea);
	}

	@DeleteMapping("/{id}")
	public void deleteTarea(@PathVariable int id) {
		tareaService.deleteTarea(id);
	}
}
