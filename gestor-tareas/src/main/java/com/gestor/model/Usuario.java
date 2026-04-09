package com.gestor.model;

/**
 * Clase que representa a un usuario del sistema.
 * Cada usuario tiene un identificador único, un nombre y una contraseña.
 * <p>
 * Esta clase incluye constructor, getters y setters para manipular los atributos.
 * </p>
 */
public class Usuario {

	/** Identificador único del usuario */
	private int id;

	/** Nombre del usuario */
	private String nombre;

	/** Contraseña del usuario */
	private String passwd;

	/**
	 * Constructor de la clase Usuario.
	 * Permite crear un usuario con id, nombre y contraseña.
	 *
	 * @param id Identificador único del usuario
	 * @param nombre Nombre del usuario
	 * @param passwd Contraseña del usuario
	 */
	public Usuario(int id, String nombre, String passwd) {
		this.id = id;
		this.nombre = nombre;
		this.passwd = passwd;
	}

	/**
	 * Devuelve el identificador del usuario.
	 *
	 * @return int ID del usuario
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece un nuevo identificador para el usuario.
	 *
	 * @param id Nuevo ID a asignar
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre del usuario.
	 *
	 * @return String Nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece un nuevo nombre para el usuario.
	 *
	 * @param nombre Nuevo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la contraseña del usuario.
	 *
	 * @return String Contraseña del usuario
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * Establece una nueva contraseña para el usuario.
	 *
	 * @param passwd Nueva contraseña a asignar
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
