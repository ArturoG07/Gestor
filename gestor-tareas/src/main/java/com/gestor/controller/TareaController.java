package com.gestor.controller;

import com.gestor.model.Tarea;
import com.gestor.model.dto.CompletarRequestDTO;
import com.gestor.model.dto.TareaDTO;
import com.gestor.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
	@PutMapping("/completar")
	public ResponseEntity<?> completarTareas(@RequestBody CompletarRequestDTO request, HttpSession session) {
		int usuarioId = (Integer) session.getAttribute("usuarioId");
		boolean resultado = tareaService.completarTarea(request.getId_tarea(), usuarioId);
		if (resultado) {
			return ResponseEntity.ok("Tarea completada");
		} else {
			return ResponseEntity.status(403).body("No autorizado para completar esta tarea");
		}
	}
	@PostMapping("/anadir")
	public void crearTarea(@RequestBody TareaDTO tarea, HttpSession session) {
		int id = (Integer) session.getAttribute("usuarioId");
		tareaService.crearTarea(tarea, id);
	}
}
