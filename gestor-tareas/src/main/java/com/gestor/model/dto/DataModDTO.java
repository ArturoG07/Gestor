package com.gestor.model.dto;

public class DataModDTO {
	String new_nombre;
	String new_passwd;
	String new_email;

	public DataModDTO(String new_passwd, String new_email, String new_nombre) {
		this.new_passwd = new_passwd;
		this.new_email = new_email;
		this.new_nombre = new_nombre;
	}

	public DataModDTO() {
	}

	public String getNew_nombre() {
		return new_nombre;
	}

	public void setNew_nombre(String new_nombre) {
		this.new_nombre = new_nombre;
	}

	public String getNew_passwd() {
		return new_passwd;
	}

	public void setNew_passwd(String new_passwd) {
		this.new_passwd = new_passwd;
	}

	public String getNew_email() {
		return new_email;
	}

	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}
}
