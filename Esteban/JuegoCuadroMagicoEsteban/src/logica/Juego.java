package logica;

import java.util.Scanner;

public class Juego {

	GrillaJuego _grilla;
	Boolean _estaJugando;
	Scanner ingreso = new Scanner(System.in);
	String tmp;
	int fila;
	int columna;
	int num;
	
	public Juego(int tamanioDeGrilla) {
		_grilla = new GrillaJuego(tamanioDeGrilla);
		_estaJugando = false;
	}
	
	public void iniciar() {
		_estaJugando = true;

		
		while(_estaJugando) {
			
			
			_grilla.imprimir();
			
//			Estaba viendo como se generaban los numeros
//			_grilla.imprimirGrillaSolucion();
			
			ingresarNumero();

			modificar(fila, columna, num);
			/* 
			 * Esto para que sirve 
			 */
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			_grilla.imprimir();
			
//          Estaba viendo como se generaban los numeros 
//			_grilla.imprimirGrillaSolucion();

			
			System.out.println("Presione Enter para seguir jugando.Caso contrario escriba y presione ENTER");
			_estaJugando = ingreso.nextLine() == "";
		}
	}
	
	public void modificar(int i, int j, int num) {
		_grilla.modificar(i, j, num);
	}
	
	public boolean gano() { 
		return _grilla.estaBienMatriz();
	}
	/* 
	 * Hay que agregar este metodo
	 */
	public void verificacionDeDatos(Integer num) {
		return ;
	}
	/*
	 * Aca hacemos para que el usuario 
	 */
	private boolean ingresarNumero() {
		
		fila=ingresarFila();
		columna=ingresarColumna();
		
		fila = Integer.valueOf(tmp.toLowerCase().charAt(0)+"");	
		columna = Integer.valueOf(tmp.toLowerCase().charAt(1)+"");
		System.out.println("Ingrese el numero: ");
		num = Integer.valueOf(ingreso.nextLine());
		return true;
		
	}

	private int ingresarColumna() {
		
		System.out.println("Ingrese la columna(1,"+this._grilla.getTamanio());
		this.verificacionDeDatos(Integer.parseInt(tmp.toLowerCase()));
		return Integer.parseInt(tmp.toLowerCase());
		
	}

	private int ingresarFila() {
		System.out.println("Ingrese la fila(1,"+this._grilla.getTamanio());
		this.verificacionDeDatos(Integer.parseInt(tmp.toLowerCase()));
		return Integer.parseInt(tmp.toLowerCase());
	}
	
}
