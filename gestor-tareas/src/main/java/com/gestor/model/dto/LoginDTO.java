package com.gestor.model.dto;

/**
 * DTO con los datos de login recibidos desde el frontend.
 */
public class LoginDTO {
	private String nombre;
	private String password;

	public LoginDTO() {}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}