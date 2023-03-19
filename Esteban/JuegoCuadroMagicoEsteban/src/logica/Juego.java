package logica;

import java.util.Scanner;

public class Juego {

	GrillaJuego _grilla;
	Boolean _estaJugando;
	Scanner ingresoUsuario = new Scanner(System.in);
	String entradaSistema;
	int filaSeleccionada;
	int columnaSeleccionada;
	int numeroSeleccionado;
	
	public Juego(int tamanioDeGrilla) {
		_grilla = new GrillaJuego(tamanioDeGrilla,1,9);
		_estaJugando = false;
	}
	
	public void iniciar() {
		_estaJugando = true;

		
		while(_estaJugando) {
			_grilla.imprimirGrillaSolucion();
			
			_grilla.imprimir();
			
//			Estaba viendo como se generaban los numeros
//			_grilla.imprimirGrillaSolucion();
			
			ingresar();

			modificar(filaSeleccionada, columnaSeleccionada, numeroSeleccionado);
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
	public void verificacionDeDatos(Integer num) {
		return ;
	}
	/*
	 * Aca hacemos para que el usuario 
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
		this.verificacionDeDatos(Integer.parseInt(entradaSistema.toLowerCase()));
		return Integer.parseInt(entradaSistema.toLowerCase());
	}

	private int ingresarColumna() {
		
		System.out.println("Ingrese la columna(1,"+this._grilla.getTamanio()+")");
		entradaSistema=ingresoUsuario.nextLine();
		this.verificacionDeDatos(Integer.parseInt(entradaSistema.toLowerCase()));
		return Integer.parseInt(entradaSistema.toLowerCase());
		
	}

	private int ingresarFila() {
		System.out.println("Ingrese la fila(1,"+this._grilla.getTamanio()+")");
		entradaSistema=ingresoUsuario.nextLine();
		this.verificacionDeDatos(Integer.parseInt(entradaSistema.toLowerCase()));
		return Integer.parseInt(entradaSistema.toLowerCase());
	}
	
}
