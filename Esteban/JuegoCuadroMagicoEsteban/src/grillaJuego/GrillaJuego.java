package grillaJuego;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrillaJuego {

	
	/**
	 * Atributos la grilla normal y la grilla Solucion cada una con su respectivo resultado
	 */
	private int[][] _grilla;
	private Map<String, Integer> _resultados;
	
	private int[][] _grillaSol;
	private Map<String, Integer> _resultadosSolucion;
	private int _tamanio;
	
	private int _minimoValorAceptable;
	private int _maximoValorAceptable;
	
	
	/*
	 * Esto sirve para el Junite hay que ver en el futuro como hago para sacarlo
	 */
	private static Integer seed;
	
	/*
	 * Genera la grilla tamanio x tamanio = n x n (cuadrada)
	 */
	protected static void cambiarSemilla(int numero) {
		GrillaJuego.seed=numero;
	}
	public GrillaJuego(int tamanio,int cota1,int cota2) {
		if(tamanio <= 1) {
			throw new IllegalArgumentException("El tamanio debe ser un entero positivo: " + tamanio);
		}
		if(cota1<1 ) {
			throw new IllegalArgumentException("El valor minimo debe ser un entero positivo: " + cota1);
		}
		if( cota2<1) {
			throw new IllegalArgumentException("El valor minimo debe ser un entero positivo: " + cota2);
		}
		if(cota2==cota1) {
			throw new IllegalArgumentException("El valor minimo tiene que ser diferente de valor maximo");
		}
		_tamanio = tamanio;
		
		
		
		_resultados = new HashMap<String, Integer>();
		_resultadosSolucion = new HashMap<String, Integer>();
		_grilla = generarGrilla(tamanio);
		_grillaSol = generarGrillaSolucion(tamanio,cota1,cota2);
		
		_minimoValorAceptable=Math.min(cota1, cota2);
		_maximoValorAceptable=Math.max(cota1, cota2);
	
	}

	/*
	 * Agrega un numero en la posicion dada de la grilla
	 */
	private  void agregarNumero(int fila, int columna, int num) {
		
		
		_grilla[fila][columna] = num;
		_resultados.put( "f" + fila   , _resultados.get("f" + fila)  +  num );
		_resultados.put( "c" + columna   , _resultados.get("c" + columna)  +  num );
	}
	
	/*
	 * Elimina el numero en una posicion dada de la grilla 
	 */
	
	
	
	private void eliminarNumero(int fila, int columna) {
		
		
		_resultados.put( "f" + fila   , _resultados.get("f" + fila)  -  _grilla[fila][columna] );
		_resultados.put( "f" + columna   , _resultados.get("f" + columna)  -  _grilla[fila][columna] );
		_grilla[fila][columna] = 0;
		
	}
	/*
	 * Modifica el valor de una celda en la grilla
	 */
	public boolean modificar(int fila, int columna, int num) {
		
		if(!verificacionIngresos(fila, columna, num)) {
			return false;
		}
		eliminarNumero(fila, columna);
		agregarNumero(fila, columna, num);
		return true;
	}
	
	
	
	public boolean verificacionIngresos(int fila, int columna, int num) {
		
		
		
		return verificacionFilaColumna(fila,columna)&&verificacionNumero(num);
	}
	
	/*
	 * Vaciamos una grilla para que el usuario intenete de vuelva jugar la grilla
	 */
	
	public void vaciarMatriz() {
		_grilla = new int[_tamanio][_tamanio];
		for(String f_c : _resultados.keySet()) {
			_resultados.put(f_c, 0);
		}
	}
	/*
	 * Verificamos que la matriz esta bien resuleta, esto podemos ver de cambiar la firma del metodo
	 */
	public boolean estaBienMatriz() {
		for(int indiceDiccionario = 0; indiceDiccionario < _tamanio; indiceDiccionario++) {
			// Comprobamos la suma de las filas
			if( !(estaBienFilayColumna(true,indiceDiccionario)&&estaBienFilayColumna(false,indiceDiccionario))) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Imprime la matriz del jugador, aca creo que estamos haciendo verificaciones hay que revisar
	 */
	
	

	
	public void imprimir() {
		
		for(int fila = 0; fila < _tamanio; fila++) {
			for(int columna = 0; columna < _tamanio; columna++) {
				if(_grilla[fila][columna] > 0) {
					if(_grilla[fila][columna] > 9) {
						System.out.print(" " +  _grilla[fila][columna]);
					}else {
						System.out.print("  " +  _grilla[fila][columna]);
					}
				}else {
					System.out.print("  " + " ");
				}
			}
			if(_resultadosSolucion.get("f" + fila) > 9) {
				System.out.println(" " +  _resultadosSolucion.get("f" + fila));
			}else {
				System.out.println("  " +  _resultadosSolucion.get("f" + fila));
			}
		}
		
		for(int columna = 0; columna < _tamanio ; columna++) {
			if(_resultadosSolucion.get("c" + columna) > 9) {
				System.out.print(" " +  _resultadosSolucion.get("c" + columna));
			}else {
				System.out.print("  " +  _resultadosSolucion.get("c" + columna));
			}
		}
		System.out.println("");
	}
	
	/* 
	 * Imprime grilla solucion
	 */
	public void imprimirGrillaSolucion() {
		for(int fila = 0; fila < _tamanio; fila++) {
			for(int columna = 0; columna < _tamanio; columna++) {
				if(_grillaSol[fila][columna] > 0) {
					if(_grillaSol[fila][columna] > 9) {
						System.out.print(" " +  _grillaSol[fila][columna]);
					}else {
						System.out.print("  " +  _grillaSol[fila][columna]);
					}
				}else {
					System.out.print("  " + " ");
				}
			}
			if(_resultadosSolucion.get("f" + fila) > 9) {
				System.out.println(" " +  _resultadosSolucion.get("f" + fila));
			}else {
				System.out.println("  " +  _resultadosSolucion.get("f" + fila));
			}
		}
		
		for(int columna = 0; columna < _tamanio ; columna++) {
			if(_resultadosSolucion.get("c" + columna) > 9) {
				System.out.print(" " +  _resultadosSolucion.get("c" + columna));
			}else {
				System.out.print("  " +  _resultadosSolucion.get("c" + columna));
			}
		}
		System.out.println("");
	}
	
	
	/*
	 * Obtenemos el tamanio de la matriz en una direccion
	 */
	public int getTamanio() {
		return this._tamanio;
	}
	
	/*
	 * Nos fijamos si la matriz esta vacia
	 */
	public boolean estaVacia() {
		boolean TodasFilasyColumnasEstanVacia = true;
		for(int indiceDiccionario=0;indiceDiccionario<_tamanio;indiceDiccionario++) {
			TodasFilasyColumnasEstanVacia=TodasFilasyColumnasEstanVacia&&_resultados.get("f"+indiceDiccionario).equals(0)&&_resultados.get("c"+indiceDiccionario).equals(0);
		}
		return TodasFilasyColumnasEstanVacia; 
	}

	/*
	 * ----------------------------------------------------------------- Metodos Privados ----------------
	 */
	
	
	
	private int[][] generarGrilla(int tamanio) {
		for(int indiceDiccionario=0; indiceDiccionario < _tamanio; indiceDiccionario++) {
			_resultados.put("f" + indiceDiccionario, 0);
			_resultados.put("c" + indiceDiccionario, 0);
		}
		return new int[tamanio][tamanio];
	}
	
	
	private int[][] generarGrillaSolucion(int tamanio, int minimoValor, int maximoValor) {
		int[][] grilla = new int[tamanio][tamanio];
		
		for(int indiceDiccionario = 0; indiceDiccionario < tamanio ; indiceDiccionario++) {
			_resultadosSolucion.put("f" + indiceDiccionario, 0);
			_resultadosSolucion.put("c" + indiceDiccionario, 0);
		}
		
		
		for(int fila = 0; fila < tamanio; fila++) {
			for(int columna = 0; columna < tamanio; columna++) {
				// Genero la grilla random
				grilla[fila][columna] = numeroAleatorio(minimoValor,maximoValor);
				
				// Sumando a cada fila
				_resultadosSolucion.put("f" + fila, _resultadosSolucion.get("f"+fila) + grilla[fila][columna]);
				
				// Sumando a cada columna
				_resultadosSolucion.put("c" + columna, _resultadosSolucion.get("c"+columna) + grilla[fila][columna]);
				
			}
		
		}
		return grilla;
	}
	
	/*
	 * Generamos un numero aleatorio entre el min y max
	 */
	private  int numeroAleatorio(int min, int max) {
		Random r = new Random(); 
		if(seed!=null) {
			
			r.setSeed(seed);
		}
		
		return r.nextInt(max) + min;
	}
	
	private int obtenerResultado(String fila_o_col, int indice) {
		if(fila_o_col.equals("f") || fila_o_col.equals("c")) {
			if(indice >= 0 && indice < _tamanio) {
				return _resultados.get(fila_o_col + indice);
			}else {
				throw new IllegalArgumentException("El numero de fila o columan debe estar en el rango: " + indice);
			}
		}else {
			throw new IllegalArgumentException("Debe introducir f - fila o ' - columna: " + fila_o_col);
		}
	}
	
	private boolean indiceValido(int indiceDiccionario) {
		
		if(indiceDiccionario<this._tamanio&&indiceDiccionario>=0) {
			return true;
		}
		return false;
	}
	/*
	 * Se fija si esta bien la columna o fila dada
	 */
	
	private boolean estaBienFilayColumna(boolean fila_columna,int indiceDiccionario) {
		
		/*
		 * Verificamos que el indice este dentro del rango
		 */
		if(!indiceValido(indiceDiccionario)) {
			return false;
		}
		
		if(fila_columna) {
			return _resultados.get("f" + indiceDiccionario) == _resultadosSolucion.get("f" + indiceDiccionario);
			
		}
		return _resultados.get("c" + indiceDiccionario) == _resultadosSolucion.get("c" + indiceDiccionario);
		
		
	}
	/*
	 * Se fija si el numero que ingreso el usuario esta bien
	 */
	private boolean verificacionNumero(int numeroIngreso) {
		if(numeroIngreso <_minimoValorAceptable  || numeroIngreso>_maximoValorAceptable ) {
			return false;
		}
		return true;
	}
	/*
	 * Se fija si la fila y columna estan dentro de rango
	 */
	
	private boolean verificacionFilaColumna(int fila,int columna) {
		if(fila < 0 || fila >= _tamanio) {
			return false;
		}
		if(columna < 0 || columna >= _tamanio) {
			return false;
		}
		return true;
	}

	
	
}