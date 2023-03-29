package juego;

import java.util.Map;

import grillaJuego.GrillaJuego;

public class Juego {

	private GrillaJuego _grilla;
	private Boolean _estaJugando;
	
	public Juego(int tamanioDeGrilla) {
		_grilla = new GrillaJuego(tamanioDeGrilla,1,9);
		_estaJugando = false;
	}
	
	public boolean iniciar() {
		_estaJugando = true;
		return _estaJugando;
	}
	
	
	/*
	 * Va a ser el ingreso de la grilla
	 */
	public void ingresoNumeroEnGrillaJuego(int i, int j, int num) {
		_grilla.modificar(i, j, num);
	}
	
	public boolean gano() { 
		return _grilla.estaBienMatriz();
	}
	
	public boolean verificacionDeDatosValidos(String fila,String columna,String numero) {
		if(!(verificacionDeConversion(fila)&&verificacionDeConversion(columna)&&verificacionDeConversion(numero))) {
			return false;
		}
		return verificacionDeDatosValidos( Integer.parseInt(fila),Integer.parseInt(columna),Integer.parseInt(numero)) ;
	}
	/* 
	 * Verifica que los datos esten bien dentro del rango para que la grilla no se rompa
	 */

	
	
	public boolean parar() {
		_estaJugando = false;
		return _estaJugando;
	}
	
	/*
	 * Verifica que el numero y columna se puedan convertir,me parece que de esto se encarga el GUI
	 */
	private boolean verificacionDeConversion(String verficarEntrada){
		try {
			Integer.parseInt(verficarEntrada);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	private boolean verificacionDeDatosValidos(int fila,int columna,int numero) {
		return this._grilla.verificacionIngresos(fila,columna,numero);
	}

	public int obtenerResultadosSolucion(String fila_o_columna, int indice) {
		try {
			return _grilla.obtenerResultadoSolucion(fila_o_columna, indice);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int obtenerValoresGrillaSolucion(int fila, int columna) {		
		return _grilla.obtenerValoresGrillaSolucion(fila,columna);
	
	}
	
	public Map<String, boolean[]> filasYColumnasQueEstanBien() {
		return _grilla.filasYColumnasQueEstanBien();
	}
}
