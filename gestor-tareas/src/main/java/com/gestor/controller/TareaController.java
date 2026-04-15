package com.gestor.controller;

import com.gestor.model.dto.CompletarRequestDTO;
import com.gestor.model.dto.RequestUpdateTareaDTO;
import com.gestor.model.dto.TareaDTO;
import com.gestor.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

	@DeleteMapping("eliminar")
	public ResponseEntity<?> eliminarTareas(@RequestBody CompletarRequestDTO request, HttpSession session) {
		int usuarioId = (Integer) session.getAttribute("usuarioId");
		boolean resultado = tareaService.eliminarTarea(request.getId_tarea(), usuarioId);
		if (resultado) {
			return ResponseEntity.ok("Tarea eliminar");
		} else {
			return ResponseEntity.status(403).body("No autorizado para eliminar esta tarea");
		}
	}

	@PutMapping("/editar")
	public ResponseEntity<?> editarTarea(@RequestBody RequestUpdateTareaDTO tarea, HttpSession session) {
		int usuarioId = (Integer) session.getAttribute("usuarioId");
		boolean resultado = tareaService.editarTarea(tarea, usuarioId);
		if (resultado) {
			return ResponseEntity.ok("Tarea editada");
		} else {
			return ResponseEntity.status(403).body("No autorizado para editar esta tarea");
		}
	}
}
