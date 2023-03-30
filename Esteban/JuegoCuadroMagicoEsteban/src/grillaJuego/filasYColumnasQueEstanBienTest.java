package grillaJuego;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class filasYColumnasQueEstanBienTest {

	GrillaJuego grilla;
	Map<String, boolean[]> comparar;

	@Before
	public void incializar() {

		grilla = new GrillaJuego(2, 1, 9);
		grilla.vaciarMatrizSolucion();
		grilla.modificarSolucion(0, 0, 2);
		grilla.modificarSolucion(0, 1, 1);
		grilla.modificarSolucion(1, 0, 2);
		grilla.modificarSolucion(1, 1, 3);
		comparar = new HashMap<String, boolean[]>();
		comparar.put("fila", new boolean[grilla.getTamanio()]);
		comparar.put("columna", new boolean[grilla.getTamanio()]);

	}

	@Test
	public void grillaVaciaYSalidaVacia() {
		grilla.vaciarMatriz();
		
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	
	@Test
	public void grillaConCeldasVaciasYSalidaVacia() {
		grilla.modificar(0, 0, 1);
		grilla.modificar(1, 1, 1);
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaConCeldasVaciasValoresCorrectosYSalidaVacia() {
		grilla.modificar(0, 0, 2);
		grilla.modificar(1, 1, 3);
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaConUnaFilaCompletaPeroNoCorrectaSalidaVacia() {
		grilla.modificar(0, 0, 1);
		grilla.modificar(0, 1, 1);
		
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaConUnaFilaCompletaCorrecta() {
		grilla.modificar(0, 0, 2);
		grilla.modificar(0, 1, 1);
		comparar.get("fila")[0]=true;
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaConUnaColumnaCompletaNoCorrectaSalidaVacia() {
		grilla.modificar(0, 1, 1);
		grilla.modificar(1, 1, 1);
		
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaConUnaColumnaCompletaCorrecta() {
		grilla.modificar(0, 1, 1);
		grilla.modificar(1, 1, 3);
		comparar.get("columna")[1]=true;
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaCompletaTodosValoresIncorrectos() {
		grilla.modificar(0, 0, 1);
		grilla.modificar(1, 1, 1);
		grilla.modificar(1, 0, 1);
		grilla.modificar(1, 1, 1);
		
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	@Test
	public void grillaCompletaTodosValoresCorrectos() {
		grilla.modificar(0, 0, 2);
		grilla.modificar(0, 1, 1);
		grilla.modificar(1, 0, 2);
		grilla.modificar(1, 1, 3);
		comparar.get("fila")[0]=true;
		comparar.get("fila")[1]=true;
		comparar.get("columna")[0]=true;
		comparar.get("columna")[1]=true;
		assertTrue(salidasIguales(grilla.filasYColumnasQueEstanBien(),comparar));
	}
	

	private boolean salidasIguales(Map<String, boolean[]> salidaMetodos,Map<String, boolean[]> comparar) {
		boolean acum = true;
		for (int indice = 0; indice < grilla.getTamanio(); indice++) {
			if (salidaMetodos.get("fila")[indice] != comparar.get("fila")[indice]) {
				
				acum=acum&&false;
			}
			if (salidaMetodos.get("columna")[indice] != comparar.get("columna")[indice]) {
				
				acum=acum&&false;
			}
		}
		return acum;
	}

}
