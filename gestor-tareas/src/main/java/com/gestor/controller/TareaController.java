package com.gestor.controller;

import com.gestor.service.TareaService;
import org.springframework.stereotype.Component;

@Component
public class TareaController {
	private TareaService tareaService;

	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}
}
