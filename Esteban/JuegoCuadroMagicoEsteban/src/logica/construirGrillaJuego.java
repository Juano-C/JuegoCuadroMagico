package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class construirGrillaJuego {

	@Test(expected = IllegalArgumentException.class)
	public void construirGrillaTamanioNegativa() {
		GrillaJuego grilla=new GrillaJuego(-1, 3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void construirGrillaValor1Menor1() {
		GrillaJuego grilla=new GrillaJuego(3, 0, 8);
	}
	@Test(expected = IllegalArgumentException.class)
	public void construirGrillaValor2Menor1() {
		GrillaJuego grilla=new GrillaJuego(3, 5, 0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void construirGrillaValor2IgualValor1() {
		GrillaJuego grilla=new GrillaJuego(3, 5, 5);
	}
	

}
