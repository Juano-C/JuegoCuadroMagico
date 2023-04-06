package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class ManipuladorArchivos {
	// Directorio del proyecto. (va cambiando dependiendo de la computador que
	// ejecute el proyecto)
	private static String _directorioProyecto = System.getProperty("user.dir");

	// Directorio donde quedara guardado el archivo tiempos.txt dentro de el
	// proyecto.
	private static String _directorioArchivo = _directorioProyecto + "//datosJuego//tiempos.txt";

	// Diccionario cargado con todas las cosas
	private static Map<Integer, String> posicionesTiempo = lineasDeText();

	/*
	 * Lee cada linea del archivo y la va aniaadiendo al diccionario
	 */
	public static Map<Integer, String> lineasDeText() {
		Map<Integer, String> diccionario = new HashMap<Integer, String>();
		ArrayList<String> lineas = (ArrayList<String>) leerArchivoTXT(_directorioArchivo);
		for (int indice = 1; indice <= 18; indice++) {
			try {
				String linea = lineas.get(indice - 1);
				diccionario.put(indice, linea);
			} catch (Exception e) {
				diccionario.put(indice, null);
			}

		}
		return diccionario;
	}

	/**
	 * lee las lineas de un archivo y devuelve todas ellas en un String. (NO SE USA)
	 * @param ruta
	 * @return un String que tiene todas las lineas de un archivo .txt
	 */
	public static String leerArchivo(String ruta) {
		String cadena = "";
		FileReader entrada = null;
		try {
			entrada = new FileReader(ruta);
			int c;
			while ((c = entrada.read()) != -1) {
				cadena += (char) c;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer archivo: " + e.getMessage());
		}
		return cadena;
	}

	/**
	 * Recibe la ruta del archivo.
	 * Lee un archivo .txt y devuelve una List<String> donde cada elemento es una linea del archivo
	 * @param rutaArchivo 
	 * @return
	 */
	public static List<String> leerArchivoTXT(String rutaArchivo) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		List<String> lineas = new ArrayList<String>(10);

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(rutaArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lineas;

	}

	/*
	 * Escribir el tiempo en el archivo de txt
	 */
	public static void escribirTiempo(String tiempo, String nombre) {
		FileWriter fichero = null;
		PrintWriter escritor = null;
		try {
			fichero = new FileWriter(_directorioArchivo);									 // Representa el fichero .txt
			escritor = new PrintWriter(fichero);  			                                 // Se usa para usar la funcion de write en el fichero 

//	            for (int i = 0; i < 10; i++)
//	                pw.println("Linea " + i);
			
			Integer puestoParada = null; // Donde se sobreescribio
			String lineaAmover = null;	// La linea que hay que mover ya que se reemplazo
			Integer[] posiciones = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}; // Todas las posiciones en orden simplemente para leer mejor
			
			// Recorro el map que representa la tabla de records..
			for(Integer puesto: posiciones) {
				String tiempoActual = obtenerTiempoFormatText(posicionesTiempo.get(puesto)); // El tiempo actualmente dentro de esa posicion
				if(elPrimerTiempoEsMenor(tiempo,tiempoActual)) { 						     // Comparo los dos tiempos
					/*
					 * Lo que hago si ese tiempo es menor:
					 * 	- Me guardo la linea que habia en esta posicion
					 * 	- Asi tambien como la posicion
					 *  - Creo la nueva linea y la agrego al map(tabla)
					 *  - Corto el ciclo
					 */
					lineaAmover = posicionesTiempo.get(puesto);							
					puestoParada = puesto;
					String nuevaLinea = tiempo + "-" + nombre; 
					posicionesTiempo.put(puesto, nuevaLinea);
					break;
				}
				else if(posicionesTiempo.get(puesto) == null){
					/*
					 * Sino como estoy recorriendo de arriba hacia abajo (de 1 a 10)
					 * si encuentro un lugar con null lo escribo ahi y corto el ciclo
					 */
					posicionesTiempo.put(puesto, tiempo + "-" + nombre);
					break;
				}
			}
			
			// Si puesto parada es null significa que no hubo una parada, por ende no hay que escribir nada.
			if(puestoParada != null) {
				
				String lineaAnterior = null;
				// Recorro el map en orden (puede mejorarse la complejidad)
				for(Integer puesto: posiciones) {
					
					// Si puesto esta debajo del puesto donde reemplazamos entonces -->
					if(puesto > puestoParada) {
						/*
						 * - Me guardo la linea actual en lineaAnterior
						 * - Reemplazo la linea por la lineaAmover
						 * - Luego la que tengo que mover sera la lineaAnterior asi que le paso el valor
						 * < Como son 10 posiciones nunca estare agregando una posicion 11. 
						 */
						lineaAnterior = posicionesTiempo.get(puesto);
						posicionesTiempo.put(puesto, lineaAmover);
						lineaAmover = lineaAnterior;
					}
				}
			}
			
			/*
			 * Una vez cambie la linea o no. Escribo devuelta el .txt gracias al map.
			 */
			for(Integer puesto: posiciones) {
				if(posicionesTiempo.get(puesto) != null) {
					escritor.println(posicionesTiempo.get(puesto));  					// Escribe una linea y agrega un salto de linea.
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	/**
	 * Obtiene el argumento "00:00:00" de una linea del .txt
	 * Para ello se usa el split que separa ambos parametros tiempo-nombre.
	 * @param cadenaPuesto
	 * @return -1 si la linea es null. tiempoTotal = "00:00:00"
	 */
	private static String obtenerTiempoFormatText(String cadenaPuesto) {
		if(cadenaPuesto == null) {
			return "-1";
		}
		String[] cadenaTiempo = cadenaPuesto.split("-");
		String tiempoTotal = cadenaTiempo[0]; // En la primera posicion se encuentra el tiempo - el otro es el nombre
		return tiempoTotal;
	}
	
	/**
	 * Recibe dos tiempos en formato "00:00:00"
	 * Se fija si el primer tiempo es menor que el segundo
	 * 		si es menor devuelve true sino false.
	 * @param tiempo
	 * @param tiempoActual
	 * @return si tiempo == null --> false ; tiempoActual == null --> true ; tiempo < tiempoActual
	 */
	private static boolean elPrimerTiempoEsMenor(String tiempo, String tiempoActual) {
		if(tiempo == null) {
			return false;
		}
		if(tiempoActual == null) {
			return true;
		}
		String[] tiempoAcolocar = tiempo.split(":");
		String[] tiempoActualmente = tiempoActual.split(":");
		Integer	tiempo_ = parsearTiempo(tiempoAcolocar);
		Integer tiempo_actualmente = parsearTiempo(tiempoActualmente);
		return tiempo_ < tiempo_actualmente;
	}


	/**
	 * Recibe un tiempo en formato "mm:ss:mlsmls" = "00:00:00" 
	 * donde mm = minutos
	 * 		 ss = segundos
	 * 		 mls = milisegundos
	 * Luego lo parsea para que me de un numero integer.
	 * @param tiempoAcolocar
	 * @return tiempoEnFormaNumeral
	 */
	private static Integer parsearTiempo(String[] tiempoAcolocar) {
		String tiempo = "";
		for(String conct: tiempoAcolocar) {
			tiempo += conct;
		}
		try {
			return Integer.valueOf(tiempo);
		} catch (Exception e) {
			return -1; // No existe el tiempo negativo en nuestra implementacion
		}
	}
	
	/**
	 * Imprime la tabla por consola
	 * Para ello uso el un diccionario que esta de forma estatica
	 * en la clase llamado posicionesTiempo
	 */
	@SuppressWarnings("unused")
	private static void imprimitTabla() {
		for(Integer indice: posicionesTiempo.keySet()) {
		System.out.println("indice: " + indice + " --> " + posicionesTiempo.get(indice));
		}
	}

	/**
	 * Devuelve la direccion de la ruta almacenada
	 * @param args
	 */
	public static String getRutaTiempos() {
		return _directorioArchivo;
	}

}
