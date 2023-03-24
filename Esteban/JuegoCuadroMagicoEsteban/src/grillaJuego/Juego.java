package grillaJuego;

import java.awt.font.NumericShaper;
import java.util.Scanner;

public class Juego {

	private GrillaJuego _grilla;
	private Boolean _estaJugando;
	private Scanner ingresoUsuario = new Scanner(System.in);
	private String entradaSistema;
	private int filaSeleccionada;
	private int columnaSeleccionada;
	private int numeroSeleccionado;
	final private static String ingresosInvalidos="1234567890";
	
	public Juego(int tamanioDeGrilla) {
		_grilla = new GrillaJuego(tamanioDeGrilla,1,9);
		_estaJugando = false;
	}
	
	public void iniciar() {
		_estaJugando = true;

		
		while(_estaJugando) {
			_grilla.imprimirGrillaSolucion();
			
			_grilla.imprimir();
			

			
			ingresar();
			if(this.verificacionDeDatos(filaSeleccionada, columnaSeleccionada, numeroSeleccionado)) {
			modificar(filaSeleccionada, columnaSeleccionada, numeroSeleccionado);
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			_grilla.imprimir();

			if(this._grilla.estaBienMatriz()) {
				_estaJugando=false;
				System.out.println("Felicidades usted gano");
				continue;
			}

			
			System.out.println("Presione Enter para seguir jugando.Caso contrario escriba y presione ENTER");
			_estaJugando = ingresoUsuario.nextLine() == "";
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
	public boolean verificacionDeDatos(int fila,int columna,int numero) {
		return this._grilla.verificacionIngresos(fila,columna,numero);
	}
	
	
	
	
	
	
	
	///////////////////////////////////////////Metodos Privados//////////////////////////////////
	
	
	
	
	/*
	 * Aca hacemos para que el usuario ingrese la fila columna y numero 
	 */
	private boolean ingresar() {
		
		filaSeleccionada=ingresarFila()-1;
		columnaSeleccionada=ingresarColumna()-1;
		numeroSeleccionado=ingresarNumero();

		return true;
		
	}

	private int ingresarNumero() {
		System.out.println("Ingrese la numero(1,9)");
		entradaSistema=ingresoUsuario.nextLine();
		
		if(verificacionDeDatos(entradaSistema)) {
			return Integer.parseInt(entradaSistema.toLowerCase());
		}
		
		//Le ponemos 0 asi no se muestra en el imprimir 
		return 0;
	}

	private int ingresarColumna() {
		
		System.out.println("Ingrese la columna(1,"+this._grilla.getTamanio()+")");
		
		entradaSistema=ingresoUsuario.nextLine();
		if(verificacionDeDatos(entradaSistema)) {
			return Integer.parseInt(entradaSistema.toLowerCase());
		}
		
		return 0;
		
	}

	private int ingresarFila() {
		System.out.println("Ingrese la fila(1,"+this._grilla.getTamanio()+")");
		entradaSistema=ingresoUsuario.nextLine();
		if(verificacionDeDatos(entradaSistema)) {
			return Integer.parseInt(entradaSistema.toLowerCase());
		}
		
		return 0;
	}
	private boolean verificacionDeDatos(String verficarEntrada){
		try {
			Integer.parseInt(verficarEntrada);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
}
