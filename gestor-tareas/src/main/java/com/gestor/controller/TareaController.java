package com.gestor.controller;

import com.gestor.model.Tarea;
import com.gestor.model.dto.TareaDTO;
import com.gestor.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
	private TareaService tareaService;

	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}

	@GetMapping("/cargarTareas")
	public ResponseEntity<?> getTareas(HttpSession session) {


		int usuarioId = (Integer) session.getAttribute("usuarioId");

		return ResponseEntity.ok(
				tareaService.getTareasUsuario(usuarioId)
		);
	}

	@PostMapping("/anadir")
	public void crearTarea(@RequestBody TareaDTO tarea, HttpSession session) {
		int id = (Integer) session.getAttribute("usuarioId");
		tareaService.crearTarea(tarea, id);
	}
}
