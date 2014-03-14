package Diciembre;

public class ManejoArraysParalelo {
	/*
	 * Manejo de listas en paralelo Dada la puntuacion de una serie de
	 * concursantes imprimir la lista ordenada de mayor a menor. mayor a menor
	 * nombre: array de 5 nombres puntos: array de 5 nombres enteros.
	 * 
	 * Para pasadas de 1 hasta 5 hacer: - para indice desde 0 hasta 5 - pasadas
	 * hacer - si puntos[indice] < puntos[indice+1] entonces -cambiamos puntos
	 * -cambiamos nombres finSi finPara finPara
	 */

	private class Registro {
		// atributos
		private String nombre;
		private int puntos;

		// Constructores
		public Registro() {

		}

		public Registro(String nombre, int puntos) {
			this.nombre = nombre;
			this.puntos = puntos;
		}
	}

	public static void main(String[] args) {

		Registro[] lista = new Registro[5];
		/*
		 * Registro[]lista = {(new Registro("Alberto",4)), (new
		 * Registro("Alberto",4)), (new Registro("Alberto",4)), (new
		 * Registro("Alberto",4)), (new Registro("Alberto",4}));
		 */
		//lista[0] = new Registro("Alberto", 4);

		int[] puntos = { 4, 7, 3, 9, 5 };
		String[] nombres = { "Alberto", "Ana", "Luis", "Eva", "Pepe" };
		int punto = 0;
		String nombre = "";

		// imprimir Array antes de Ordenar
		System.out.println("*** Array ANTES de ordenarlo ***");
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(nombres[i] + "\t" + puntos[i]);
		}

		// Proceso de ordenacion
		for (int pasada = 1; pasada < puntos.length; ++pasada) {
			for (int i = 0; i < puntos.length - pasada; ++i) {
				if (puntos[i] < puntos[i + 1]) {
					punto = puntos[i];
					puntos[i] = puntos[i + 1];
					puntos[i + 1] = punto;
					nombre = nombres[i];
					nombres[i] = nombres[i + 1];
					nombres[i + 1] = nombre;

				}
			}
		}

		// imprime la ordenacion
		System.out.println("\n*** Array DESPUES de ordenarlo ***");
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(nombres[i] + "\t" + puntos[i]);
		}

	}

}
