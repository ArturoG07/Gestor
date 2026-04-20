package com.gestor.controller;

import com.gestor.model.Usuario;
import com.gestor.model.dto.DataModDTO;
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
	@PutMapping("/update")
	public ResponseEntity<?> updateUsuario(@RequestBody DataModDTO data, HttpSession session) {
		try {
			int id = (Integer) session.getAttribute("usuarioId");
			if (!"Default".equals(data.getNew_nombre())) {
				usuarioService.actualizarNombre(data.getNew_nombre(), id);
			}
			if (!"Default".equals(data.getNew_email())) {
				usuarioService.actualizarEmail(data.getNew_email(), id);
			}
			if (!"Default".equals(data.getNew_passwd())) {
				usuarioService.actualizarPasswd(data.getNew_passwd(), id);
			}
			return ResponseEntity.ok("Usuario actualizado correctamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
