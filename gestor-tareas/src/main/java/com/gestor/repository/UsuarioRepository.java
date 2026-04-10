package com.gestor.repository;

import com.gestor.config.ConexionBD;
import com.gestor.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la lista de todos los usuarios y sus metodos correspondientes para añadir, borrar, buscar o comprobar si un usuario ya existe
 */
@Repository
public class UsuarioRepository {
	private List<Usuario> usuarios;

	/**
	 * Constructor de el repositorio
	 */
	public UsuarioRepository() {
		this.usuarios = obtenerUsuarios();
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
	 * Devolver todos los usuarios
	 * @return usuarios lista de usuarios
	 */
	public List<Usuario> buscarTodos() {
		return usuarios;
	}


	public List<Usuario> obtenerUsuarios() {
		List<Usuario> lista = new ArrayList<>();

		String sql = "SELECT * FROM Usuarios";

		try (Connection conn = ConexionBD.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Usuario u = new Usuario(
						rs.getInt("ID"),
						rs.getString("Nombre"),
						rs.getString("Passwd")
				);

				lista.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
