package fileManager;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FileManager {

	// Directorio del proyecto. (va cambiando dependiendo de la computador que ejecute el proyecto)
	private static String _directorioProyecto = System.getProperty("user.dir");
	
	// Directorio donde quedara guardado el archivo tiempos.txt dentro de el proyecto.
	private static String _directorioArchivo = _directorioProyecto + "//datosJuego//tiempos.txt";
			

	public static Map<Integer, String> lineasDeText(File archivo){
		Map<Integer,String> diccionario = new HashMap<Integer,String>();
		return diccionario;
	}
		
	/*
	 * Escribe en un archivo. Puede sobreescribir o no dependiendo de si pasan true = sobrescribir o
	 * 	false = no sobreescribir.
	 */
	public static boolean escribirEnArchivo(File archivo, boolean sobreecribir) {
		return false;
	}
	
	/*
	 * Ordena el archivo pasado como parametro
	 */
	public static LinkedList<String> ordenarArchivo(File archivo, boolean ascendente){
		LinkedList<String> lineasOrdenadas = new LinkedList<String>();
		
		return lineasOrdenadas; 
	}
	
	/*
	 * Ordena los archivos basados en los tiempos
	 */
	public static void ordenarArchivosJuego(File archivo) {
		// Obtiene todas las lineas del archivo
		// Las lee y las va agregando a una lista ordenadamente
		// Carga esa lista dentro del archivo (sobreescribe).
	}
	
	/*
	 * Metodo que coloca el tiempo en el archivo que usara el juego.
	 */
	public static void colocarTiempoJuego(String tiempoFinal) {
		// Va al archivo tiempos.txt
		// Escribe el tiempo
		// Ordena todo devuelta
	}
	
	/*
	 * Obtiene los 10 mejores tiempos del juego
	 */
	public static String[] losDiezMejoresTiempos(){
		String[] mejoresTiempos = new String[10];
		
		// Lee las 10 primeras lineas y las va a�adiendo
			// Si no hay mas lineas para leer rellena con "" (vacio)
		
		return mejoresTiempos;
	}
	
	/*
	 * Limpio el archivo si tiene mas de 11 tiempos
	 */
	public static void limpiarArchivo() {
		// Agarro el archivo
		// Cuento la cantidad de lineas que tiene
			// Si tiene mas de 11 aggaro esas 11
			// Sobreescribo ese archivo con los 11 mejores Tiempos
	}
	
}	
