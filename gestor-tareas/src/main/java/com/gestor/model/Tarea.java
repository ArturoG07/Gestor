package com.gestor.model;

import javax.persistence.*;

/**
 * Clase que representa una tarea en el sistema.
 * Cada tarea tiene un identificador único, un nombre, una descripción y un estado.
 * <p>
 * El estado de la tarea puede ser:
 * <ul>
 *     <li>PENDIENTE: La tarea fue creada y aún no se ha iniciado.</li>
 *     <li>EN_PROCESO: La tarea está en ejecución.</li>
 *     <li>COMPLETADA: La tarea fue finalizada.</li>
 * </ul>
 * Al crear una tarea nueva, su estado por defecto es {@link Estado#PENDIENTE}.
 * </p>
 */
@Entity
@Table(name = "Tareas")
public class Tarea {

	/** Enum que define los posibles estados de la tarea */
	public enum Estado {
		/** La tarea fue creada y aún no se ha iniciado. */
		PENDIENTE,
		/** La tarea está en progreso. */
		EN_PROCESO,
		/** La tarea ha sido completada. */
		COMPLETADA
	}

	/** Identificador único de la tarea, generado automáticamente por la BD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** Nombre de la tarea */
	@Column(name = "Nombre", nullable = false)
	private String nombre;

	/** Descripción de la tarea */
	@Column(name = "Descripcion")
	private String descripcion;

	/**
	 * Estado actual de la tarea.
	 * Se guarda como texto en la BD (ej: "PENDIENTE") en vez de como número.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "Estado", nullable = false)
	private Estado estadoTarea;

	/** ID del usuario propietario de la tarea */
	@Column(name = "IdUsuario", nullable = false)
	private int idUsuario;

	/**
	 * Constructor vacío requerido por JPA.
	 */
	public Tarea() {}

	/**
	 * Constructor de la clase Tarea.
	 *
	 * @param id          Identificador único de la tarea
	 * @param nombre      Nombre de la tarea
	 * @param descripcion Descripción detallada de la tarea
	 * @param idUsuario   ID del usuario propietario
	 * @param estadoTarea Estado inicial de la tarea
	 */
	public Tarea(int id, String nombre, String descripcion, int idUsuario, Estado estadoTarea) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoTarea = estadoTarea;
		this.idUsuario = idUsuario;
	}

	/** @return ID de la tarea */
	public int getId() { return id; }

	/** @param id Nuevo ID a asignar */
	public void setId(int id) { this.id = id; }

	/** @return Nombre de la tarea */
	public String getNombre() { return nombre; }

	/** @param nombre Nuevo nombre a asignar */
	public void setNombre(String nombre) { this.nombre = nombre; }

	/** @return Descripción de la tarea */
	public String getDescripcion() { return descripcion; }

	/** @param descripcion Nueva descripción a asignar */
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

	/** @return Estado actual de la tarea */
	public Estado getEstadoTarea() { return estadoTarea; }

	/** @param estadoTarea Nuevo estado a asignar */
	public void setEstadoTarea(Estado estadoTarea) { this.estadoTarea = estadoTarea; }

	/** @return ID del usuario propietario */
	public int getIdUsuario() { return idUsuario; }

	/** @param idUsuario Nuevo ID de usuario a asignar */
	public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}