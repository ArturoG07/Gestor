import controller.TareaController;
import controller.UsuarioController;
import repository.TareaRepository;
import repository.UsuarioRepository;
import service.TareaService;
import service.UsuarioService;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		UsuarioRepository usuarios = new UsuarioRepository(new ArrayList<>());
		TareaRepository tareas = new TareaRepository(new ArrayList<>());

		UsuarioService usuarioService = new UsuarioService(usuarios);
		TareaService tareaService = new TareaService(tareas, usuarios);

		UsuarioController usuario = new UsuarioController(usuarioService);
		TareaController tarea = new TareaController(tareaService);

		//Bucle principal...
	}
}
