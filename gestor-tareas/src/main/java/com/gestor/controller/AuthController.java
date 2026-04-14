package com.gestor.controller;

import com.gestor.model.Usuario;
import com.gestor.model.dto.LoginDTO;
import com.gestor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
public class AuthController {

	@Autowired private UsuarioRepository usuarioRepo;
	@Autowired private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO,
	                               HttpServletRequest request) {

		String nombre = loginDTO.getNombre();
		String password = loginDTO.getPassword();

		Usuario usuario = usuarioRepo.findByNombre(nombre).orElse(null);

		if (usuario == null || !passwordEncoder.matches(password, usuario.getPasswd())) {
			return ResponseEntity.status(401).body("Credenciales incorrectas");
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("usuarioId", usuario.getId());
		session.setAttribute("username", usuario.getNombre());

		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("mensaje", "Login correcto");

		return ResponseEntity.ok(respuesta);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		SecurityContextHolder.clearContext();
		session.invalidate();
		return ResponseEntity.ok("Sesión cerrada");
	}

	@GetMapping("/me")
	public ResponseEntity<?> quienSoy(HttpSession session) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return ResponseEntity.status(401).body("No autenticado");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("username", username);
		return ResponseEntity.ok(respuesta);
	}
}
