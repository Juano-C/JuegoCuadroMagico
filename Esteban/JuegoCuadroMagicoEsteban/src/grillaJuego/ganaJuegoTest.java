package grillaJuego;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ganaJuegoTest {
	
	
	
	GrillaJuego grilla;
	@Before
	public void incializar() {
	GrillaJuego.cambiarSemilla(5);
	grilla=new GrillaJuego(2, 1, 9);
	
	
	}
	@Test
	public void ganoJuego() {
		grilla.modificar(0, 0, 9);
		
		grilla.modificar(0, 1, 9);
		grilla.modificar(1, 1, 9);
		grilla.modificar(1, 0, 9);
		
		assertTrue(grilla.estaBienMatriz());
		
	}
	@Test
	public void noGanoJuego() {
		grilla.modificar(0, 0, 9);
		grilla.modificar(0, 1, 1);
		grilla.modificar(1, 1, 9);
		grilla.modificar(1, 0, 9);
		assertFalse(grilla.estaBienMatriz());
		
	}

}
