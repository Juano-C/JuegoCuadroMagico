package controladores;

import frontend.VentanaDificultad;
import frontend.VentanaInGame;
import frontend.VentanaMain;
import frontend.VentanaRecord;
import juego.Juego;
import juego.Juego.Dificultad;

public class Controlador {
	
	private static VentanaInGame _ventanaInGame = new VentanaInGame();
	private static VentanaDificultad _ventanaDificultad = new VentanaDificultad();
	private static VentanaMain _ventanaMain = new VentanaMain();
	private static VentanaRecord _ventanaRecords = new VentanaRecord();
	private static Juego _juego;
	private static String _sonido;
	private static Dificultad _dificultad;
	
	public static void abrirVentanaInGame() {
		_ventanaInGame.setVisible(true);
		_ventanaDificultad.setVisible(false);
		_ventanaMain.setVisible(false);
		_ventanaRecords.setVisible(false);
	}
	
	
	public static void abrirVentanaDificultad() {
		_ventanaMain.setVisible(false);
		_ventanaDificultad.setVisible(true);
		_ventanaInGame.setVisible(false);
		_ventanaRecords.setVisible(false);

	}
	
	public static void abrirVentanaMain() {
		_ventanaDificultad.setVisible(false);
		_ventanaInGame.setVisible(false);
		_ventanaMain.setVisible(true);
		_ventanaRecords.setVisible(false);
	}
	public static void abrirVentanaRecord() {
		_ventanaRecords.setVisible(true);
		_ventanaMain.setVisible(false);
		_ventanaDificultad.setVisible(false);
		_ventanaInGame.setVisible(false);
		
	}
	public static void cerrarVentanaInGame() {
		_ventanaInGame.setVisible(false);
	}
	public static void cerrarVentanaDificultad() {
		_ventanaDificultad.setVisible(false);
	}
	public static void cerrarVentanaMain() {
		_ventanaMain.setVisible(false);
	}
	public static void cerrarVentanaRecords() {
		_ventanaRecords.setVisible(false);
	}
	
//	public static void crearJuego(Dificultad dificultad) {
//		_juego = new Juego(_dificultad);
//		_juego.iniciar();
//	}
//	
	public static void setearDificultad(Dificultad dificultad) {
		_dificultad = dificultad;
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


	public static Dificultad getDificultad() {
		return _dificultad;
	}

}
