package repository;

import model.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la lista de todas las tareas
 */
public class TareaRepository {

	private static List<Tarea> tareas = new ArrayList<>();

	public TareaRepository(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public void añadirTarea(Tarea tarea) {
		tareas.add(tarea);
	}

	public Tarea buscarPorId(int id) {
		Tarea tareaBuscada = null;
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				tareaBuscada = tarea;
			}
		}
		return tareaBuscada;
	}
}
