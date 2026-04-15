package com.gestor.service;

import com.gestor.model.Tarea;
import com.gestor.model.dto.RequestUpdateTareaDTO;
import com.gestor.model.dto.TareaDTO;
import com.gestor.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio de las tareas.
 */
@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepo;

	/**
	 * Devuelve todas las tareas de un usuario.
	 *
	 * @param idUsuario ID del usuario propietario
	 * @return lista de tareas del usuario
	 */
	public List<Tarea> getTareasUsuario(int idUsuario) {
		return tareaRepo.findByIdUsuario(idUsuario);
	}

	/**
	 * Crea una nueva tarea a partir de un DTO y la guarda en la BD.
	 *
	 * @param dto       datos de la tarea recibidos desde el frontend
	 * @param idUsuario ID del usuario propietario
	 */
	public void crearTarea(TareaDTO dto, int idUsuario) {
		Tarea tarea = new Tarea();
		tarea.setNombre(dto.getTitulo());
		tarea.setDescripcion(dto.getDescripcion());
		tarea.setEstadoTarea(dto.getEstado());
		tarea.setIdUsuario(idUsuario);
		tareaRepo.save(tarea);
	}

	/**
	 * Actualiza una tarea existente en la BD.
	 * Si la tarea no existe, no hace nada.
	 *
	 * @param tarea tarea con los datos actualizados
	 * @return la tarea actualizada, o null si no existía
	 */
	public Tarea updateTarea(Tarea tarea) {
		if (!tareaRepo.existsById(tarea.getId())) {
			return null;
		}
		return tareaRepo.save(tarea);
	}

	/**
	 * Elimina una tarea por su ID.
	 *
	 * @param id ID de la tarea a eliminar
	 */
	public void deleteTarea(int id) {
		tareaRepo.deleteById(id);
	}

	public boolean completarTarea(int idTarea, int idUsuario) {
		Tarea tarea = tareaRepo.findById(idTarea).orElse(null);
		if (tarea != null && tarea.getIdUsuario() == idUsuario) {
			tarea.setEstadoTarea(Tarea.Estado.COMPLETADA);
			tareaRepo.save(tarea);
			return true;
		} else {
			return false;
		}
	}

	public boolean eliminarTarea(int idTarea, int idUsuario) {
		Tarea tarea = tareaRepo.findById(idTarea).orElse(null);
		if (tarea != null && tarea.getIdUsuario() == idUsuario) {
			tareaRepo.delete(tarea);
			return true;
		} else {
			return false;
		}
	}

	public boolean editarTarea(RequestUpdateTareaDTO tarea, int id_usuario) {
		Tarea tareaExistente = tareaRepo.findById(tarea.getId_tarea()).orElse(null);
		if (tareaExistente != null && tareaExistente.getIdUsuario() == id_usuario) {
			tareaExistente.setNombre(tarea.getTitulo());
			tareaExistente.setDescripcion(tarea.getDescripcion());
			tareaExistente.setEstadoTarea(tarea.getEstado());
			tareaRepo.save(tareaExistente);
			return true;
		} else {
			return false;
		}
	}
}