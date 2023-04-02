package controladores;
import javax.swing.JFrame;

import frontend.VentanaCargarRecord;
import frontend.VentanaDificultad;
import frontend.VentanaInGame;
import frontend.VentanaMain;
import frontend.VentanaRecord;
import juego.Juego;
import juego.Juego.Dificultad;
import sonido.Audios;

public class Controlador {
	
	private static VentanaInGame _ventanaInGame = new VentanaInGame();
	private static VentanaDificultad _ventanaDificultad = new VentanaDificultad();
	private static VentanaMain _ventanaMain = new VentanaMain();
	private static VentanaRecord _ventanaRecords = new VentanaRecord();
	private static VentanaCargarRecord _ventanaCargaRecord= new VentanaCargarRecord();
	private static Juego _juego;
	@SuppressWarnings("unused")
	private static String _sonido;
	private static Dificultad _dificultad;
	private static boolean musica=true;
	
	
	public static  void manejarMusica() {
		if(musica) {
			musica=false;
			Audios.musicaStop();
			return;
		}else {
			musica=true;
			Audios.musicaPlay();
		}
		
		
	}
	public static void abrirVentana(JFrame ventanaAbrir,JFrame ventanaCerrar) {
		ventanaAbrir.setLocationRelativeTo(null);
		ventanaAbrir.setVisible(true);
		ventanaCerrar.setVisible(false);
		ventanaAbrir.setResizable(false);
		
	}
	public static VentanaRecord getVentanaRecords() {
		return _ventanaRecords;
	}
	public static VentanaInGame getVentanaInGame() {
		return _ventanaInGame;
	}
	public static VentanaDificultad getVentanaDificultad() {
		return _ventanaDificultad;
	}
	public static VentanaMain getVentanaMain() {
		return _ventanaMain;
	}
	

	
	public static void abrirVentanaInGame() {
		_ventanaInGame.setVisible(true);
		_ventanaDificultad.setVisible(false);
		_ventanaMain.setVisible(false);
		_ventanaRecords.setVisible(false);
	}
	
	
	public static void abrirVentanaDificultad() {
		_ventanaDificultad.setVisible(true);
		_ventanaMain.setVisible(false);
		_ventanaInGame.setVisible(false);
		_ventanaRecords.setVisible(false);

	}
	
	public static void abrirVentanaMain() {
		_ventanaMain.setVisible(true);
		_ventanaDificultad.setVisible(false);
		_ventanaInGame.setVisible(false);
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
	public static String getRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void cargarNombre(String nombre) {
		return ;
		
	}

}
