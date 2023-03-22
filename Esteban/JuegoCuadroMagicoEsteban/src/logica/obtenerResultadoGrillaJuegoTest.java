package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class obtenerResultadoGrillaJuegoTest {

	@Test
	public void vaciarGrillaVacia() {
		GrillaJuego grilla=new GrillaJuego(2, 1, 2);
		
		assertNull(grilla.obtenerResultado("f", 1));
	}

}
