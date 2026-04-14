package com.gestor.model.dto;

import com.gestor.model.Tarea;

public class TareaDTO {
	private String titulo;
	private String descripcion;
	private Tarea.Estado estado;

	public TareaDTO(String titulo, String descripcion, String estado) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Tarea.Estado.valueOf(estado.toUpperCase());
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
