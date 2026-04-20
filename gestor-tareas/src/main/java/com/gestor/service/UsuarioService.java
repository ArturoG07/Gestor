package com.gestor.service;

import com.gestor.model.Usuario;
import com.gestor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio de los usuarios.
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Devuelve el ID de un usuario por su nombre.
	 * @param nombre nombre del usuario
	 * @return ID del usuario, o -1 si no existe
	 */
	public int getIdUsuario(String nombre) {
		return usuarioRepo.findByNombre(nombre)
				.map(Usuario::getId)
				.orElse(-1);
	}

	/**
	 * Comprueba si las credenciales de login son correctas.
	 * Compara la contraseña recibida con el hash guardado en la BD.
	 * @param nombre   nombre del usuario
	 * @param password contraseña en texto plano introducida por el usuario
	 * @return true si las credenciales son correctas, false si no
	 */
	public boolean loginCorrecto(String nombre, String password) {
		Optional<Usuario> usuario = usuarioRepo.findByNombre(nombre);
		return usuario.isPresent() &&
				passwordEncoder.matches(password, usuario.get().getPasswd());
	}
	public Usuario getDataUsuario(int id) {
		Usuario usuario = usuarioRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return usuario;
	}
	public void actualizarNombre(String nombre, int id) {
		Usuario usuario = usuarioRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		usuario.setNombre_completo(nombre);
		usuarioRepo.save(usuario);
	}

	public void actualizarPasswd(String password, int id) {
		Usuario usuario = usuarioRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		usuario.setPasswd(passwordEncoder.encode(password));
		usuarioRepo.save(usuario);
	}

	public void actualizarEmail(String email, int id) {
		Usuario usuario = usuarioRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		usuario.setEmail(email);
		usuarioRepo.save(usuario);
	}
}