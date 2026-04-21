package com.gestor.model.dto;

/**
 * DTO con los datos de login recibidos desde el frontend.
 */
public class LoginDTO {
	private String nombre;
	private String password;
	private String rol;

	public LoginDTO() {}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getRol() { return rol; }
	public void setRol(String rol) { this.rol = rol; }

}