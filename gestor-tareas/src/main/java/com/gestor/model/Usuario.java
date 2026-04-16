package com.gestor.model;

import javax.persistence.*;

/**
 * Clase que representa a un usuario del sistema.
 * Cada usuario tiene un identificador único, un nombre y una contraseña.
 * <p>
 * La contraseña se almacena hasheada con BCrypt, nunca en texto plano.
 * </p>
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {

	/** Identificador único del usuario, generado automáticamente por la BD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Nombre de usuario, usado para el login.
	 * Debe ser único en el sistema.
	 */
	@Column(name = "Nombre", nullable = false, unique = true)
	private String nombre;

	/**
	 * Contraseña del usuario almacenada como hash BCrypt.
	 * Nunca se guarda ni devuelve en texto plano.
	 */
	@Column(name = "passwd", nullable = false)
	private String passwd;
	/**
	 * Correo electrónico del usuario.
	 */
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	/**
	 *
	 */
	@Column(name = "rol", nullable = false)
	private String rol;
	/**
	 * Nombre completo del usuario no unico
	 */
	@Column(name="nombre_completo",nullable=false)
	private String nombre_completo;
	/**
	 * Constructor vacío requerido por JPA.
	 */
	public Usuario() {}

	/**
	 * Constructor de la clase Usuario.
	 *
	 * @param id     Identificador único del usuario
	 * @param nombre Nombre del usuario
	 * @param passwd Contraseña ya hasheada del usuario
	 * @param email  Correo electrónico del usuario
	 * @param rol    Rol del usuario (e.g., "admin", "user")
	 * @param nombre_completo Nombre completo del usuario tiene formato
	 */
	public Usuario(int id, String nombre, String passwd, String email, String rol, String nombre_completo) {
		this.id = id;
		this.nombre = nombre;
		this.passwd = passwd;
		this.email = email;
		this.rol = rol;
		this.nombre_completo = nombre_completo;
	}

	/** @return ID del usuario */
	public int getId() { return id; }

	/** @param id Nuevo ID a asignar */
	public void setId(int id) { this.id = id; }

	/** @return Nombre del usuario */
	public String getNombre() { return nombre; }

	/** @param nombre Nuevo nombre a asignar */
	public void setNombre(String nombre) { this.nombre = nombre; }

	/** @return Contraseña hasheada del usuario */
	public String getPasswd() { return passwd; }

	/** @param passwd Nueva contraseña hasheada a asignar */
	public void setPasswd(String passwd) { this.passwd = passwd; }
	/** @return Email del usuario*/
	public String getEmail() { return email; }

	/**@param email Nuevo email del usuario*/
	public void setEmail(String email) { this.email = email; }
	/**@return Rol del usuario*/
	public String getRol() { return rol; }
	/**@param rol Nuevo rol del usuario*/
	public void setRol(String rol) { this.rol = rol; }
	public String getNombre_completo() { return nombre_completo; }
	public void setNombre_completo(String nombre_completo) { this.nombre_completo = nombre_completo; }
}