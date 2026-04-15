package com.gestor.model.dto;

import com.gestor.model.Tarea;

public class RequestUpdateTareaDTO {
	private int id_tarea;
	private String titulo;
	private String descripcion;
	private Tarea.Estado estado;

	public RequestUpdateTareaDTO(int id_tarea, String titulo, String descripcion, Tarea.Estado estado) {
		this.id_tarea = id_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public RequestUpdateTareaDTO() {}

	public int getId_tarea() {
		return id_tarea;
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
