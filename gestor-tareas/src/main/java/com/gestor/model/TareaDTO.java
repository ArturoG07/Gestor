package com.gestor.model;

public class TareaDTO {
	private String titulo;
	private String descripcion;
	private Tarea.Estado estado;

	public TareaDTO(String titulo, String descripcion, String estado) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Tarea.Estado.valueOf(estado);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Tarea.Estado getEstado() {
		return estado;
	}
}
