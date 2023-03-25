package juego;

import static org.junit.Assert.*;

import org.junit.Test;

public class juegoTest {

	
	

	@Test
	public void iniciarJuego() {
		Juego juego=new Juego(2);
		assertTrue(juego.iniciar());
	}
	@Test
	public void iniciarJuegoDosVeces() {
		Juego juego=new Juego(2);
		juego.iniciar();
		assertTrue(juego.iniciar());
	}
	
	@Test
	public void pararJuego() {
		Juego juego=new Juego(2);
		
		assertFalse(juego.parar());
	}
	@Test
	public void pararJuego2Veces() {
		Juego juego=new Juego(2);
		juego.parar();
		assertFalse(juego.parar());
	}


}
