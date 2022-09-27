package dam2.inicial.ejercicioHashMap1;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Diccionario1_2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HashMap<String, String> diccionario = new HashMap<String, String>();

		diccionario.put("abrir", "open");
		diccionario.put("escribir", "writ");
		diccionario.put("leer", "read");
		diccionario.put("ejecutar", "run");
		diccionario.put("transmitir", "transmit");
		diccionario.put("cerrar", "close");
		diccionario.put("calcular", "calculate");
		diccionario.put("modificar", "modify");
		diccionario.put("reparar", "repair");
		diccionario.put("revisar", "check");
		diccionario.put("obtener", "get");
		diccionario.put("aprender", "learn");
		diccionario.put("buscar", "search");
		diccionario.put("realizar", "realize");
		diccionario.put("cambiar", "change");
		diccionario.put("activar", "activate");
		diccionario.put("solucionar", "sort out");
		diccionario.put("manipular", "handle");
		diccionario.put("superar", "live thorough");
		diccionario.put("comprender", "understand");

		String idiomaActual = "ES";
		String opcion;
		String clave;
		String valor;
		System.out.println("IDIOMA: " + idiomaActual);

		do {

			System.out.println(
					" 1.AÑADIR\n 2.MODIFICAR\n 3.ELIMINAR\n 4.BUSCAR\n 5.CAMBIAR IDIOMA\n 6.PALABRAS ALEATORIAS\n 0.SALIR");

			System.out.println("Elige una opción del menú");

			opcion = sc.next();

			switch (opcion) {

			// añadir palabra
			case "1":
				System.out.println("Introduce palabra");
				clave = sc.next();

				while (diccionario.containsKey(clave)) {
					System.out.println("Esta palabra ya exite");
					System.out.println("Introduce una nueva palabra");
					clave = sc.next();
				}

				System.out.println("Introduce traducción");
				valor = sc.next();
				diccionario.put(clave, valor);
				System.out.println("Palabra y traducción añadida con exixto: " + clave + " --> " + valor);

				break;

			// modificar palabra
			case "2":

				System.out.println("Introduce palabra");
				clave = sc.next();

				if (diccionario.containsKey(clave)) {
					System.out.println(clave);
					System.out.println("Introduce traducción");
					valor = sc.next();
					diccionario.put(clave, valor);
					System.out.println(clave + " ---> " + valor);

				} else {

					System.out.println("No puede modificar algo que no existe, vuelva a elegir una opción del menú");
				}

				break;

			// eliminar palabra
			case "3":
				System.out.println("Introduce palabra a eliminar");
				clave = sc.next();

				if (diccionario.containsKey(clave)) {
					System.out.println(clave);
					diccionario.remove(clave);

				} else {
					System.out.println("No se puede eliminar una palabra que no existe, elija otra opción del menú");
				}

				break;

			/**
			 * buscar las palabras que empiecen por una determinada letra, mostrando los
			 * pares palabra-traducción de todas aquellas palabras encontradas (que empiecen
			 * por la letra concreta).
			 */

			case "4":
				System.out.println("Introduzca letra");
				String letra = sc.next();

				for (String key : diccionario.keySet()) {
					if (key.substring(0, 1).equalsIgnoreCase(letra)) {
						valor = diccionario.get(key);
						System.out.println(key + " ---> " + valor);

					}
				}

				break;

			// cambiar de diccionario
			case "5":

				HashMap<String, String> nuevoDiccionario = new HashMap<String, String>();

				for (String key : diccionario.keySet()) {
					nuevoDiccionario.put(diccionario.get(key), key);
				}

				diccionario = nuevoDiccionario;

				if (idiomaActual.equalsIgnoreCase("ES")) {
					System.out.println("IDIOMA: EN");
					idiomaActual = "EN";
				} else {
					System.out.println("IDIOMA: ES");
				}

				break;

			/**
			 * Realiza un programa que escoja al azar 5 palabras en español del
			 * minidiccionario del ejercicio anterior. El programa irá pidiendo que el
			 * usuario teclee la traducción al inglés de cada una de las palabras y
			 * comprobará si son correctas. Al final, el programa deberá mostrar cuántas
			 * respuestas son válidas y cuántas erróneas.
			 */

			case "6":
				int aciertos = 0;
				int fallos = 0;

				// creo una copia del diccionario para al sacar los valores aleatorios
				// eliminarlos para que no se repitan y no modificar el diccionario original
				HashMap<String, String> diccionarioNuevo = new HashMap<String, String>();
				diccionarioNuevo.putAll(diccionario);

				// Sacar numero aleatorio entre 0 y 4

				for (int i = 0; i < 5; i++) {
					int aleatorio = Math.abs(new Random().nextInt() % 5);

					// Saco las claves a una matriz
					String[] claves = diccionarioNuevo.keySet().toArray(new String[] {});

					// Ahora puedo sacar claves[indice aleatorio calculado antes]
					System.out.println(claves[aleatorio]);

					System.out.println("Introduzca traducción de: " + claves[aleatorio]);
					valor = sc.next();

					// compruebo si la traducción es correcta
					if (diccionario.get(claves[aleatorio]).equalsIgnoreCase(valor)) {
						System.out.println("traducción correcta " + claves[aleatorio] + "--->" + valor);
						aciertos++;

					} else {
						System.out.println("traduccion incorrecta");
						fallos--;
					}
					diccionarioNuevo.remove(claves[aleatorio]);
				}

				System.out.println("Has tenido " + aciertos + " aciertos y " + fallos + " fallos");

				break;

			case "0":
				System.out.println("Hasta pronto");

				break;

			default:
				System.out.println("Introduce solo opciones disponibles en el menú");
			}
		} while (!opcion.equals("0"));

		System.out.println(diccionario);

	}

	

}
