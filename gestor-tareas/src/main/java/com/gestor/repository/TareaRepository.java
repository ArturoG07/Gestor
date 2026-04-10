package com.gestor.repository;

import com.gestor.model.Tarea;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Repository;

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
		Tarea tarea = new Tarea(1, "tarea1", "desc", 1);
		Tarea tarea2 = new Tarea(2, "tarea2", "desc", 1);
		this.tareas = new ArrayList<>();
		tareas.add(tarea);
		tareas.add(tarea2);
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
}
