package com.gestor.model;

public class UsuarioLoginDTO {
	private String nombre;
	private String passwd;

	public UsuarioLoginDTO(String nombre, String passwd) {
		this.nombre = nombre;
		this.passwd = passwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
