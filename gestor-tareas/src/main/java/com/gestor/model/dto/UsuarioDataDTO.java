package com.gestor.model.dto;

public class UsuarioDataDTO {
	private String rol;
	private String nombre;
	private String email;
	private String nombre_completo;

	public UsuarioDataDTO(String rol, String nombre, String email, String nombre_completo) {
		this.rol = rol;
		this.nombre = nombre;
		this.email = email;
		this.nombre_completo = nombre_completo;
	}
	public UsuarioDataDTO() {}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
}
