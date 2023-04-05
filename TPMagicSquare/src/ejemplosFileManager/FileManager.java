package ejemplosFileManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {

	private static final String _directorio_actual = System.getProperty("user.dir");
	private static final String _dir_tiempos = _directorio_actual + "//tiempos//";
	
	public static boolean crearArchivo(String fileName) {
		try {
			File archivo = new File(fileName);
			return archivo.createNewFile();
		} catch (Exception e) {
			return false;
		}		
	}
	
	public static boolean escribirEnArchivo(String fileName, String text,boolean noSobreEscribir) {
		try {
			File fichero = new File(_directorio_actual + "//" + fileName);
			
			if(fichero.exists()) {				
				
				BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero, noSobreEscribir));
				escritor.append(text);
				escritor.close();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return true;
			}else {
				return false;
			}	
		} catch (Exception e) {
			return false;
		}
		
	};
	
	public static String leerArchivo(String fileName) {		
		try {
		    String contenido = new String(Files.readAllBytes(Paths.get(_directorio_actual+ "//" + fileName))); 
			return contenido;
		} catch (Exception e) {
			return "No se pudo leer el archivo " +  fileName;
		}
	};
	
	public static boolean existeArchivo(String fileName) {
		return new File(_directorio_actual + "//" + fileName).exists();
	}
	
	public static boolean eliminarArchivo(String fileName) {
		File archivo = new File(fileName);
		return archivo.delete();
	}
	
	public static void mostrarArchivos() {
	    File micarpeta= new File(_directorio_actual);
	    
        File[] listaFicheros=micarpeta.listFiles();
 
        for (int i=0;i < listaFicheros.length ;i++) {
 
                System.out.println(listaFicheros[i].getName());
 
        }
	}
	
	public static String rutaDelArchivo() {
		return _directorio_actual;
	}
	


	public static void main(String[] args) {
		/*
		 * Un pequeño programa para ver si funciona la clase de que maneja archivos
		 */
		Scanner input = new Scanner(System.in);
		int eleccion;
		do {
			System.out.println("Ingrese la opcion que desea realizar");
			System.err.println("1- Crear un nuevo archivo");
			System.out.println("2- Escribir en un archivo");
			System.out.println("3- Leer un archivo");
			System.out.println("4- Mostrar los archivos disponibles");
			System.out.println("5- Eliminar un archivo");
			System.out.println("6- Salir");
			eleccion = input.nextInt();
			
			
			switch (eleccion) {
			
			/*
			 * Crear un archivo
			 */
			case 1: {
				System.out.println("Escriba el nombre del archivo a crear: ");
				String nombre = input.next();
				if(FileManager.crearArchivo(nombre)) {
					System.out.println("Se creo con exito el archivo " + nombre +  " en el directorio:");
					System.out.println(FileManager.rutaDelArchivo());
					System.out.println();
				}else{
					System.out.println("El archivo ya existe o no pudo ser creado.");
				};
				break;
			}
			
			/*
			 * Escribir en un archivo
			 */
			case 2:{
				System.out.println("Escriba el nombre del archivo en el que desea escribir: ");
				String nombreArchivo = input.next();
				if(FileManager.existeArchivo(nombreArchivo)) {
					System.out.println("Desea agregar o sobreescribir el archivo");
					System.out.println("1 - Agregar");
					System.out.println("2 - Sobreescribir");
					int eleccion_ = input.nextInt();
					Scanner input_ = new Scanner(System.in);
					switch (eleccion_) {
						case 1: {
							System.out.println("Ingrese el texto que desea agregar: ");
							String texto = input_.nextLine();
							FileManager.escribirEnArchivo(nombreArchivo, texto, true);
							break;
					}
						case 2:{
							System.out.println("Ingrese el texto para sobreescribir!!: ");
							String texto = input_.nextLine();
							FileManager.escribirEnArchivo(nombreArchivo, texto, false);
							break;
					}
					default:
						System.out.println("Su eleccion es invalida.");
						break;
					}
				}else{
					System.err.println("No existe el archivo.");
				}
				break;
			}
			
			/*
			 * Leer un archivo
			 */
			case 3:{
				System.out.println("Ingrese el nombre del archivo que desea leer: ");
				String nombreArchivo = input.next();
				if(FileManager.existeArchivo(nombreArchivo)) {
					System.out.println(FileManager.leerArchivo(nombreArchivo));
				}else {
					System.out.println("No existe el archivo en el directorio.");
				}
				
				break;
			}
			
			case 4:{
				System.out.println("A continuacion se muestan los archivos disponibles: ");
				FileManager.mostrarArchivos();
				break;
			}
			case 5:{
				System.out.println("Escriba el nombre del archivo a eliminar: ");
				String nombre = input.next();
				if(FileManager.eliminarArchivo(nombre)) {
					System.out.println("Se elimino correctamente el archivo " +  nombre +  " del directorio: ");
					System.out.println(FileManager.rutaDelArchivo());
				};
			}
			
			case 6:{

				break;
			}
			default:
				System.out.println("No se encontro esa opcion");
			}			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} while (eleccion != 6);
		
		input.close();
		System.out.println("Salio con exito.");
	}
	
}
