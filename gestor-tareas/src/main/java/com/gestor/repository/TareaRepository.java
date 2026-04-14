package com.gestor.repository;

import com.gestor.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para la entidad Tarea.
 * Spring genera automáticamente todas las consultas a la BD.
 */
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

	/**
	 * Busca todas las tareas de un usuario concreto.
	 * @param idUsuario ID del usuario propietario
	 * @return lista de tareas del usuario
	 */
	List<Tarea> findByIdUsuario(int idUsuario);
}