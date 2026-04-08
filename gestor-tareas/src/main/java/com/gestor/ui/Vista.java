package com.gestor.ui;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase Vista
 * <p>
 * Proporciona métodos para mostrar mensajes en consola con formatos predefinidos:
 * títulos, subtítulos, avisos, errores, mensajes de éxito e información.
 * Permite mantener la presentación separada de la lógica de negocio,
 * facilitando la lectura y el mantenimiento del código.
 * </p>
 * <p>
 * Se instancia con el constructor {@link #Vista()} y sus métodos se llaman
 * sobre la instancia para mostrar mensajes.
 * </p>
 */
@Component
public class Vista {

	/**
	 * Formato para títulos. Se muestra en mayúsculas con líneas decorativas.
	 */
	private static final String FORMATO_TITULO =
			"\n====================================\n   %s\n====================================\n";

	/**
	 * Formato para subtítulos. Se usa para secciones dentro de la consola.
	 */
	private static final String FORMATO_SUBTITULO = "\n---- %s ----\n";

	/**
	 * Formato para avisos generales con icono ⚠️.
	 */
	private static final String FORMATO_AVISO = "⚠️  %s\n";

	/**
	 * Formato para errores con icono ❌.
	 */
	private static final String FORMATO_ERROR = "❌ ERROR: %s\n";

	/**
	 * Formato para mensajes de éxito con icono ✅.
	 */
	private static final String FORMATO_EXITO = "✅ %s\n";

	/**
	 * Formato para mensajes informativos con icono ℹ️.
	 */
	private static final String FORMATO_INFO = "ℹ️  %s\n";

	/**
	 * Constructor de la clase Vista.
	 * Actualmente no requiere parámetros, pero permite inicialización futura.
	 */
	public Vista() {
	}

	/**
	 * Muestra un título en mayúsculas con el formato predefinido.
	 *
	 * @param texto Texto del título a mostrar
	 */
	public void titulo(String texto) {
		System.out.printf(FORMATO_TITULO, texto.toUpperCase());
	}

	/**
	 * Muestra un subtítulo con el formato predefinido.
	 *
	 * @param texto Texto del subtítulo a mostrar
	 */
	public void subtitulo(String texto) {
		System.out.printf(FORMATO_SUBTITULO, texto);
	}

	/**
	 * Muestra un mensaje de aviso con icono ⚠️.
	 *
	 * @param texto Texto del aviso
	 */
	public void aviso(String texto) {
		System.out.printf(FORMATO_AVISO, texto);
	}

	/**
	 * Muestra un mensaje de error con icono ❌.
	 *
	 * @param texto Texto del error
	 */
	public void error(String texto) {
		System.out.printf(FORMATO_ERROR, texto);
	}

	/**
	 * Muestra un mensaje de éxito con icono ✅.
	 *
	 * @param texto Texto del mensaje de éxito
	 */
	public void exito(String texto) {
		System.out.printf(FORMATO_EXITO, texto);
	}

	/**
	 * Muestra un mensaje de información con icono ℹ️.
	 *
	 * @param texto Texto del mensaje de información
	 */
	public void info(String texto) {
		System.out.printf(FORMATO_INFO, texto);
	}

	/**
	 * Imprime una línea separadora simple para dividir secciones.
	 */
	public void separador() {
		System.out.println("------------------------------------");
	}

	/**
	 * Limpia la consola simulando un "clear screen" imprimiendo varias líneas vacías.
	 * Útil para mantener la interfaz más limpia en aplicaciones de consola.
	 */
	public void limpiarPantalla() {
		for (int i = 0; i < 50; i++) System.out.println();
	}

	/**
	 * Muestra por pantalla todas las opciones
	 */
	public void mostrarOpciones(List<String> opciones) {
		for (int i= 0; i < opciones.size(); i++) {
			if (i+1 != opciones.size()) {
				System.out.print(i+1 + ")"); } else {
				System.out.print(0 + ")");
			}
			System.out.print(" " + opciones.get(i));
			System.out.println();
		}
	}

}
