package com.gestor.repository;

import com.gestor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad Usuario.
 * Spring genera automáticamente todas las consultas a la BD.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	/**
	 * Busca un usuario por su nombre.
	 * @param nombre Nombre del usuario a buscar
	 * @return Optional con el usuario si existe, vacío si no
	 */
	Optional<Usuario> findByNombre(String nombre);
}