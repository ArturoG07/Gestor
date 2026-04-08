package com.gestor;

import com.gestor.controller.TareaController;
import com.gestor.controller.UsuarioController;
import com.gestor.ui.Vista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		UsuarioController usuario = context.getBean(UsuarioController.class);
		TareaController tarea = context.getBean(TareaController.class);
		Vista vista = context.getBean(Vista.class);

		//Bucle principal...
	}
}
