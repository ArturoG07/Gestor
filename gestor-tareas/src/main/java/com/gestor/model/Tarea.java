package com.gestor.model;

/**
 * Clase que representa una tarea en el sistema.
 * Cada tarea tiene un identificador único, un nombre, una descripción y un estado.
 * <p>
 * El estado de la tarea puede ser:
 * <ul>
 *     <li>PENDIENTE: La tarea fue creada y aún no se ha iniciado.</li>
 *     <li>EN_PROGRESO: La tarea está en ejecución.</li>
 *     <li>COMPLETADA: La tarea fue finalizada.</li>
 * </ul>
 * Al crear una tarea nueva, su estado por defecto es {@link Estado#PENDIENTE}.
 * </p>
 */
public class Tarea {

	/** Enum que define los posibles estados de la tarea */
	public enum Estado {
		/** La tarea fue creada y aún no se ha iniciado.
		 *
		 */
 PENDIENTE,
		/**
		 * La tarea esta en progreso
		 */
		EN_PROGRESO,
		/**
		 * La tarea ha sido completada
		 */
		COMPLETADA }

	/** Identificador único de la tarea */
	private int id;

	/** Nombre de la tarea */
	private String nombre;

	/** Descripción de la tarea */
	private String descripcion;

	/** Estado actual de la tarea */
	private Estado estadoTarea;

	private int idUsuario;
	/**
	 * Constructor de la clase Tarea.
	 * Inicializa la tarea con id, nombre y descripción, asignando por defecto
	 * el estado {@link Estado#PENDIENTE}.
	 *
	 * @param id Identificador único de la tarea
	 * @param nombre Nombre de la tarea
	 * @param descripcion Descripción detallada de la tarea
	 */
	public Tarea(int id, String nombre, String descripcion, int idUsuario, Estado estadoTarea) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoTarea = estadoTarea;
		this.idUsuario = idUsuario;
	}

	/**
	 * Devuelve el identificador de la tarea.
	 *
	 * @return int ID de la tarea
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece un nuevo identificador para la tarea.
	 *
	 * @param id Nuevo ID a asignar
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la tarea.
	 *
	 * @return String Nombre de la tarea
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece un nuevo nombre para la tarea.
	 *
	 * @param nombre Nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la descripción de la tarea.
	 *
	 * @return String Descripción de la tarea
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece una nueva descripción para la tarea.
	 *
	 * @param descripcion Nueva descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el estado actual de la tarea.
	 *
	 * @return Estado Estado actual de la tarea
	 */
	public Estado getEstadoTarea() {
		return estadoTarea;
	}

	/**
	 * Establece un nuevo estado para la tarea.
	 *
	 * @param estadoTarea Nuevo estado a asignar
	 */
	public void setEstadoTarea(Estado estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
