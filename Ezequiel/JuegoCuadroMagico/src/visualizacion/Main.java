package visualizacion;

import logica.Juego;

/* Lo que falta:
 * private boolean estaCompletaFyC() - Falta implementarla (no se muy bien lo que buscaba hacer)
 * añadir al diagrama las variables/metodos de ser requerido
 * 
 * 
 * 
 * 
 * Lo que ya esta hecho:
 * 
 * Se implento casi todos los metodos del modelado.
 * 
 * 
 * 
 * 
 * Lo que falta retocar/problemas a solucionar:
 * 
 * 
 * 
 * 
 * 
 * Observaciones:
 * private int obtenerResultado(String fila_o_col, int i) - no la ando usando, pero dejenlo
 * 															para la parte visual.
 * Las soluciones se crean, pero tienen un patron que se repite (revisar si afectara el tp).
 * 
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		Juego jueguito = new Juego(4);
		jueguito.iniciar();
	}
}
