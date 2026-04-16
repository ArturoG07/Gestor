package com.gestor.controller;

import com.gestor.model.Usuario;
import com.gestor.model.dto.UsuarioDataDTO;
import com.gestor.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/data")
	public ResponseEntity<?> getDataUsuario(HttpSession session) {
		Usuario data_usuario = usuarioService.getDataUsuario((Integer) session.getAttribute("usuarioId"));
		UsuarioDataDTO user = new UsuarioDataDTO(
				data_usuario.getRol(),
				data_usuario.getNombre(),
				data_usuario.getEmail(),
				data_usuario.getNombre_completo()
		);
		return ResponseEntity.ok(user);
	}

}
