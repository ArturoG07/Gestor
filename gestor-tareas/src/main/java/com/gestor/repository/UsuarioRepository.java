package com.gestor.repository;

import com.gestor.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la lista de todos los usuarios y sus metodos correspondientes para añadir, borrar, buscar o comprobar si un usuario ya existe
 */
@Repository
public class UsuarioRepository {
	private List<Usuario> usuarios = new ArrayList<>();

	/**
	 * Constructor de el repositorio
	 * @param usuarios Lista de usuarios
	 */
	public UsuarioRepository() {
		this.usuarios = new ArrayList<>();
	}

	/**
	 * Guarda un usuario en la lista
	 * @param u usuario a guardar
	 */
	public void save(Usuario u) {
		usuarios.add(u);
	}

	/**
	 * Busca un usuario por su nombre y lo devuelve
	 * @param nombre Nombre del usuario a buscar
	 * @return usuarioBuscado El usuario al que pertenece ese nombre, o null si no se encuentra
	 */
	public Usuario buscarPorNombre(String nombre) {
		Usuario usuarioBuscado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre)) {
				usuarioBuscado = usuario;
			}
		}
		return usuarioBuscado;
	}

	/**
	 * Devuelve un usuario por su id, o null si no se encuentra
	 * @param id id del usuario a buscar
	 * @return Usuario encontrado por el id, o null si no se encontró
	 */
	public Usuario buscarPorId(int id) {
		Usuario usuarioBuscado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				usuarioBuscado = usuario;
			}
		}
		return usuarioBuscado;
	}

	/**
	 * Devolver todos los usuarios
	 * @return usuarios lista de usuarios
	 */
	public List<Usuario> buscarTodos() {
		return usuarios;
	}

	/**
	 * Eliminar por id y devolver true si se eliminó, false si no se encontró el usuario
	 * @param id Id del usuario a eliminar
	 * @return boolean indicando si se eliminó el usuario o no
 	 */
	public boolean eliminarPorId(int id) {
		return usuarios.removeIf(u -> u.getId() == id);
	}

	/**
	 * Comprueba si ya hay un usuario con ese nombre en la lista
	 * @param nombre Nombre a comprobar
	 * @return true si existe o false si no
	 */
	public boolean existeNombre(String nombre) {
		return usuarios.stream().anyMatch(u -> u.getNombre().equals(nombre));
	}
	/**
	 * Comprueba si ya hay un usuario con ese id en la lista
	 * @param id Id a comprobar
	 * @return true si existe o false si no
	 */
	public boolean existeId(int id) {
		return usuarios.stream().anyMatch(u -> u.getId() == id);
	}
}
