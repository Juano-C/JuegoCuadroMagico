package controladores;
import javax.swing.JFrame;

import fileManager.ManipuladorArchivos;
import frontend.VentanaCargarRecord;
import frontend.VentanaDificultad;
import frontend.VentanaInGame;
import frontend.VentanaMain;
import frontend.VentanaRecord;
import juego.Juego.Dificultad;
import sonido.Audios;

public class Controlador {
	
	private static VentanaInGame _ventanaInGame = new VentanaInGame();
	private static VentanaDificultad _ventanaDificultad = new VentanaDificultad();
	private static VentanaMain _ventanaMain = new VentanaMain();
	private static VentanaRecord _ventanaRecords = new VentanaRecord();
	private static VentanaCargarRecord _ventanaCargaRecord= new VentanaCargarRecord();
	private static Dificultad _dificultad;
	private static boolean musica=true;
	private static String _tiempoLogrado = null;
	
	
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
	
	public static void reproducirClick() {
		Audios.sonidoClick();
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
	public static VentanaCargarRecord getVentanaCargarRecord() {
		return _ventanaCargaRecord;
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

	public static Dificultad getDificultad() {
		return _dificultad;
	}
	
	public static void setearTiempoLogrado(String tiempo) {
		_tiempoLogrado = tiempo;
	}
	
	public static void cargarNombre(String nombre) {
		ManipuladorArchivos.escribirTiempo(_tiempoLogrado , nombre);		
	}

	public static String getRecord() {
		return _tiempoLogrado;
	}

}
