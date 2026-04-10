package com.gestor.controller;

import com.gestor.model.UsuarioLoginDTO;
import com.gestor.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/login")
	public boolean login(@RequestBody UsuarioLoginDTO datos) {
		return usuarioService.loginCorrecto(datos.getNombre(), datos.getPasswd());
	}
	@GetMapping("/pedirId")
	public int getID(@RequestParam String nombre) {
		return usuarioService.getIdUsuario(nombre);
	}
}
