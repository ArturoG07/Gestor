package com.gestor.repository;

import com.gestor.config.ConexionBD;
import com.gestor.model.Tarea;
import com.gestor.model.TareaDTO;
import com.gestor.model.Usuario;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la lista de todas las tareas y sus metodos para buscar, guardar, borrar, o comprobar existencias
 */
@Repository
public class TareaRepository {

	private List<Tarea> tareas;

	/**
	 * Crea la lista de tareas
	 */
	public TareaRepository() {
		this.tareas = obtenerTareas();
	}

	/**
	 * Guarda una tarea en la lista
	 * @param t tarea a guardar
	 */
	public void save(Tarea t) {
		tareas.add(t);
	}

	/**
	 * Busca una tarea por su id y la devuelve si existe, o devuelve null si no
	 * @param id Id de la tarea que se quiere buscar
	 * @return la tarea con ese id, o null si no hay
	 */
	public Tarea buscarPorId(int id) {
		Tarea tareaBuscada = null;
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				tareaBuscada = tarea;
			}
		}
		return tareaBuscada;
	}
	public List<Tarea> buscarTareasUsuario(int idUsuario) {
		List<Tarea> lista = new ArrayList<>();
		for (Tarea tarea : tareas) {
			if (tarea.getIdUsuario() == idUsuario) {
				lista.add(tarea);
			}
		}
		return lista;
	}
	/**
	 * Devuelve la lista con todas las tareas
	 * @return la lista de las tareas
	 */
	public List<Tarea> buscarTodos() {
		return tareas;
	}
	/**
	 * Eliminar por id y devolver true si se eliminó, false si no se encontró la tarea
	 * @param id Id de la tarea a eliminar
	 * @return boolean indicando si se eliminó la tarea o no
	 */
	public boolean eliminarPorId(int id) {
		return tareas.removeIf(t -> t.getId() == id);
	}

	/**
	 * Comprueba si existe una tarea con ese id
	 * @param id Id que se quiere comprobar
	 * @return true si existe, o false si no
	 */
	public boolean existeId(int id) {
		return tareas.stream().anyMatch(t -> t.getId() == id);
	}

	public List<Tarea> obtenerTareas() {
		List<Tarea> lista = new ArrayList<>();

		String sql = "SELECT * FROM Tareas";

		try (Connection conn = ConexionBD.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Tarea t = new Tarea(
						rs.getInt("ID"),
						rs.getString("Nombre"),
						rs.getString("Descripcion"),
						rs.getInt("IdUsuario"),
						Tarea.Estado.valueOf(rs.getString("Estado"))
				);

				lista.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	public void guardar(TareaDTO tarea, int idUsuario) {

		String sql = "INSERT INTO tareas (nombre, descripcion, id_usuario, estado) VALUES (?, ?, ?, ?)";

		try (Connection conn = ConexionBD.getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, tarea.getTitulo());
			stmt.setString(2, tarea.getDescripcion());
			stmt.setString(3, tarea.getEstado().name());
			stmt.setInt(4, idUsuario);


			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
