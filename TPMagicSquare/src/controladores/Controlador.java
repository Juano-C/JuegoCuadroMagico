package controladores;

import frontend.VentanaComenzar;
import frontend.VentanaDificultad;
import frontend.VentanaMain;
import juego.Juego;

public class Controlador {
	
	private static VentanaComenzar _ventanaComenzar = new VentanaComenzar();
	private static VentanaDificultad _ventanaDificultad = new VentanaDificultad();
	private static VentanaMain _ventanaMain = new VentanaMain();
	private static Juego _juego;
	private static String _sonido;
	
	public static void abrirVentanaComenzar() {
		_ventanaComenzar.setVisible(true);
		_ventanaDificultad.setVisible(false);
		_ventanaMain.setVisible(false);
	}
	
	
	public static void abrirVentanaDificultad() {
		_ventanaMain.setVisible(false);
		_ventanaDificultad.setVisible(true);
		_ventanaComenzar.setVisible(false);
	}
	
	public static void abrirVentanaMain() {
		_ventanaDificultad.setVisible(false);
		_ventanaComenzar.setVisible(false);
		_ventanaMain.setVisible(true);
	}
	
	public static void cerrarVentanaComenzar() {
		_ventanaComenzar.setVisible(false);
	}
	
	public static void cerrarVentanaDificultad() {
		_ventanaDificultad.setVisible(false);
	}
	
	public static void cerrarVentanaMain() {
		_ventanaMain.setVisible(false);
	}
	
	public static void crearJuego(int tamanio) {
		_juego = new Juego(tamanio);
		_juego.iniciar();
	}


	public static int obtenerResultadosSolucion(String fila_o_col, int indice) {
		if(_juego != null) {
			return _juego.obtenerResultadosSolucion(fila_o_col, indice);
		}
		return 0;
	}


	public static void ingresoNumeroEnGrillaJuego(int fila, int columna, int num) {
		if(_juego != null) {
			_juego.ingresoNumeroEnGrillaJuego(fila, columna, num);
		}
	}

}
