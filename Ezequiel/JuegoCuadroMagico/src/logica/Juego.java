package logica;

import java.util.Scanner;

public class Juego {

	GrillaJuego _grilla;
	Boolean _estaJugando;
	
	public Juego(int tamanioDeGrilla) {
		_grilla = new GrillaJuego(tamanioDeGrilla);
		_estaJugando = false;
	}
	
	public void iniciar() {
		_estaJugando = true;
		Scanner ingreso = new Scanner(System.in);
		String tmp;
		int fila;
		int columna;
		int num;
		
		while(_estaJugando) {
			
			
			_grilla.imprimir();
			
//			Estaba viendo como se generaban los numeros
//			_grilla.imprimirGrillaSolucion();
			
			System.out.println("Ingrese la fila y columna a modificar: 12 = (1,2) , 01 = (0,1) , etc" );
			tmp = ingreso.nextLine();
			fila = Integer.valueOf(tmp.toLowerCase().charAt(0)+"");	
			columna = Integer.valueOf(tmp.toLowerCase().charAt(1)+"");
			System.out.println("Ingrese el numero: ");
			num = Integer.valueOf(ingreso.nextLine());

			modificar(fila, columna, num);
			
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
		return _grilla.estaCompletaMatriz();
	}
	
	public boolean verificacionDeDatos() {
		return false;
	}
	
}
