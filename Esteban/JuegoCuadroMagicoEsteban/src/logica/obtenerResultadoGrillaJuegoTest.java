package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class obtenerResultadoGrillaJuegoTest {

	@Test
	public void valorGrillaVacia() {
		GrillaJuego grilla=new GrillaJuego(2, 1, 2);
		
		assertEquals(grilla.obtenerResultado("f", 1),0);
	}
	@Test
	public void valorGrilla() {
		GrillaJuego grilla=new GrillaJuego(2, 1, 2);
		
		assertEquals(grilla.obtenerResultado("f", 1),0);
	}

}
