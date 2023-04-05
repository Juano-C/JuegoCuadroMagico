package fileManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JOptionPane;

public class FileManager {

	// Directorio del proyecto. (va cambiando dependiendo de la computador que ejecute el proyecto)
	private static String _directorioProyecto = System.getProperty("user.dir");
	
	// Directorio donde quedara guardado el archivo tiempos.txt dentro de el proyecto.
	private static String _directorioArchivo = _directorioProyecto + "//datosJuego//tiempos.txt";
			
	/*
	 * Lee cada linea del archivo y la va a�adiendo al diccionario
	 */
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
		/** Necesito obtener todo el archivo **/
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
	
	
	/*
	 * Lee todo un archivo pasandole la ruta del archivo como parametro.
	 * Devuelve un String que tiene todas las lineas.
	 */
	public static String leerArchivo(String ruta){
	    String cadena = "";
	    FileReader entrada = null;
	    try {
	        entrada = new FileReader(ruta);
	        int c;
	        while((c = entrada.read()) != -1){
	            cadena += (char)c;
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al leer archivo: "+e.getMessage());
	    }
	    return cadena;
	}
	
	
	
	/*
	 * Sobreescribe la i-esima linea de un .txt pasado como ruta.
	 * recibe la nueva linea como String 
	 * recibe la posicion como int
	 * y la ruta del .txt como String
	 */
	public static void ingresar(String nuevaLinea, int posicion, String ruta){
	    FileWriter fichero = null;
	    PrintWriter escritor = null;
	    try {
	        fichero = new FileWriter(ruta);
	        escritor = new PrintWriter(fichero);
	        escritor.flush();
	        String split[] = leerArchivo(ruta).split("\n"); // Genero el array de lineas del .txt
	        split[posicion] = nuevaLinea; // Reemplaza la i-esima posicion
	        for(int x = 0; x < split.length; x++){
	            escritor.write(split[x]);
	            escritor.println();
	         }
	        escritor.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de texto: "+e.getMessage());
	    } finally {
	        if(fichero != null){
	            try {
	                fichero.close();
	            } catch (IOException e) {
	                JOptionPane.showMessageDialog(null, "Error al cerrar archivo de texto: "+e.getMessage());
	            }
	        }
	    }
	}
	
	public static void colocarTiempoJuego(String tiempo, String nombre) {
	    FileWriter fichero = null;
	    PrintWriter escritor = null;
	    try {
	        fichero = new FileWriter(_directorioArchivo);
	        escritor = new PrintWriter(fichero);
	        escritor.flush();
	        String lineasDeTxt[] = obtenerDiezLineas(); // Obtengo un arreglo de tamanio 10
	        
	        // Si el archivo esta vacio
	        if(lineasDeTxt == null || lineasDeTxt.length <= 0) {
	        	String primeraLinea = tiempo + "-" + nombre;
	        	escritor.write(primeraLinea);
	        	escritor.println();
	        	escritor.close();
	        	return;
	        	
	        }
	        // Busco y reemplazo
	        for(int i = 0; i < lineasDeTxt.length; i++) {
	        	try {
		        	String linea[] = lineasDeTxt[i].split("-");
		        	Integer tiempoActual = obtenerTiempoParseado(linea[0]);
		        	Integer tiempoPasado = obtenerTiempoParseado(tiempo);
		        	if(tiempoPasado < tiempoActual) {
		        		cambiarTiempo(tiempo, nombre, lineasDeTxt, i);
		        		break;
		        	}
				} catch (Exception e) {
					cambiarTiempo(tiempo, nombre, lineasDeTxt, i+1);
					break;
				}

	        }
	        
	        
	      //  split[posicion] = nuevaLinea; // Reemplaza la i-esima posicion
	        
	        // Reescribo el archivo
	        for(int x = 0; x < lineasDeTxt.length; x++){
	        	if(lineasDeTxt[x] != null) {
	        		escritor.write(lineasDeTxt[x]);
//		            escritor.println();
	        	}
	         }
	        
	        escritor.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de texto: "+e.getMessage());
	    } finally {
	        if(fichero != null){
	            try {
	                fichero.close();
	            } catch (IOException e) {
	                JOptionPane.showMessageDialog(null, "Error al cerrar archivo de texto: "+e.getMessage());
	            }
	        }
	    }  
		
		
	}
	
	/*
	 * Crea un arreglo con las 10 lineas de el .txt
	 * Para ello crea el arreglo de tamanio 10, coloca las lineas actuales que alla dentro
	 * y devuelve este nuevo arreglo.
	 */
	private static String[] obtenerDiezLineas() {
		String[] lineas = new String[10];
		String[] lineasActuales = leerArchivo(_directorioArchivo).split("\n\n"); // Genero el array de lineas del .txt
		for(int i=0; i < lineasActuales.length; i++) {
			lineas[i] = lineasActuales[i];
		}
		for(String a: lineasActuales) {
			System.out.println(a);
		}
		return lineas;
	}

	/*
	 * Cambio el tiempo y desplaza todo uno asi abajo.
	 */
	private static void cambiarTiempo(String tiempo, String nombre, String[] lineasDeTxt, int indice) {
		String nuevaLinea = tiempo + "-" + nombre;
		Integer indiceActual = indice;
		String lineaAcambiar = lineasDeTxt[indiceActual];
		lineasDeTxt[indiceActual] = nuevaLinea;
		if(indiceActual == lineasDeTxt.length-1) { // Si ambos son iguales estoy en el final del arreglo 
			return;								   // Entonces solo reemplazo y me voy.
		}
		String lineaAnterior;
		/* Aqui corro todo un espacio hacia abajo */
		for(int ind = indiceActual + 1; ind < lineasDeTxt.length; ind++) {
			lineaAnterior = lineasDeTxt[ind]; // Guardo la linea que hay en esta posicion
			lineasDeTxt[ind] = lineaAcambiar; // La reemplazo
			lineaAcambiar = lineaAnterior;    // Ahora en la siguiente iteracion cambiara la linea que quedo guardada
		}
		return;
	}

	/*
	 * Pasa el la linea de texto 00:00:00 a un valor en integer
	 */
	public static Integer obtenerTiempoParseado(String lineaTexto) {
		String[] tiempo = lineaTexto.split(":");
		String tiempoTotal = "";
		for(String s: tiempo) tiempoTotal += s;
		try {
			return Integer.valueOf(tiempoTotal);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static void main(String[] args) {
//		FileManager.colocarTiempoJuego("00:06:10", "Pedrito");
//		System.out.println(leerArchivo(_directorioArchivo));
//		FileManager.colocarTiempoJuego("01:01:20", "Manolo");

		
	}
	
}	
