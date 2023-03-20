package logica;

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
	
	
	/*
	 * Genera la grilla tamanio x tamanio = n x n (cuadrada)
	 */
	public GrillaJuego(int tamanio) {
		if(tamanio <= 0) {
			throw new IllegalArgumentException("El tamanio debe ser un entero positivo: " + tamanio);
		}
		_tamanio = tamanio;
		
		
		
		_resultados = new HashMap<String, Integer>();
		_resultadosSolucion = new HashMap<String, Integer>();
		_grilla = generarGrilla(tamanio);
		_grillaSol = generarGrillaSolucion(tamanio);

	
	}
	/*
	 * Agrega un numero en la posicion dada de la grilla
	 */
	private  void agregarNumero(int i, int j, int num) {
		if(i < 0 || i >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + i);
		}
		if(j < 0 || j >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + j);
		}
		if(num <= 0) {
			throw new IllegalArgumentException("El numero debe ser un entero positivo: " + num); 
		}
		
		_grilla[i][j] = num;
		_resultados.put( "f" + i   , _resultados.get("f" + i)  +  num );
		_resultados.put( "c" + j   , _resultados.get("c" + j)  +  num );
	}
	
	/*
	 * Elimina el numero en una posicion dada de la grilla 
	 */
	
	// Podria llamarse borrarNumero - eliminarPoscion 
	// sacar se podria referir a obtener 
	
	private void sacarNumero(int i, int j) {
		if(i < 0 || i >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + i);
		}
		if(j < 0 || j >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + j);
		}
		
		_resultados.put( "f" + i   , _resultados.get("f" + i)  -  _grilla[i][j] );
		_resultados.put( "f" + j   , _resultados.get("f" + j)  -  _grilla[i][j] );
		_grilla[i][j] = 0;
		
	}
	/*
	 * Modifica el valor de una celda en la grilla
	 */
	public void modificar(int i, int j, int num) {
		if(i < 0 || i >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + i);
		}
		if(j < 0 || j >= _tamanio) {
			throw new IllegalArgumentException("Fuera de rango: " + j);
		}
		/*
		 * Aca hay que agregar cota superior dependiendo la cantidad de digitos que tomemos 
		 */
		if(num <= 0) {
			throw new IllegalArgumentException("El numero debe ser un entero positivo: " + num); 
		}
		
		sacarNumero(i, j);
		agregarNumero(i, j, num);
	}
	/*
	 * Tendriamos que ver esta funcion, ver si lo que retornar es si la columna o la fila esta completo o si nos dice si esta bien esta fila o columna
	 */
	// Falta implementar
	private boolean estaCompletaFyC() {
		return false;
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
	public boolean estaCompletaMatriz() {
		for(int i = 0; i < _tamanio; i++) {
			// Comprobamos la suma de las filas
			if(_resultados.get("f" + i) == _resultadosSolucion.get("f" + i)) {
				return false;
			}
			// Comprobamos la suma de las columnas
			if(_resultados.get("c" + i) == _resultadosSolucion.get("c" + i)) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Imprime la matriz del jugador, aca creo que estamos haciendo verificaciones hay que revisar
	 */
	
	public void imprimir() {
		
		for(int i = 0; i < _tamanio; i++) {
			for(int j = 0; j < _tamanio; j++) {
				if(_grilla[i][j] > 0) {
					if(_grilla[i][j] > 9) {
						System.out.print(" " +  _grilla[i][j]);
					}else {
						System.out.print("  " +  _grilla[i][j]);
					}
				}else {
					System.out.print("  " + " ");
				}
			}
			if(_resultadosSolucion.get("f" + i) > 9) {
				System.out.println(" " +  _resultadosSolucion.get("f" + i));
			}else {
				System.out.println("  " +  _resultadosSolucion.get("f" + i));
			}
		}
		
		for(int j = 0; j < _tamanio ; j++) {
			if(_resultadosSolucion.get("c" + j) > 9) {
				System.out.print(" " +  _resultadosSolucion.get("c" + j));
			}else {
				System.out.print("  " +  _resultadosSolucion.get("c" + j));
			}
		}
		System.out.println("");
	}
	
	/* 
	 * Imprime grilla solucion
	 */
	public void imprimirGrillaSolucion() {
		for(int i = 0; i < _tamanio; i++) {
			for(int j = 0; j < _tamanio; j++) {
				if(_grillaSol[i][j] > 0) {
					if(_grillaSol[i][j] > 9) {
						System.out.print(" " +  _grillaSol[i][j]);
					}else {
						System.out.print("  " +  _grillaSol[i][j]);
					}
				}else {
					System.out.print("  " + " ");
				}
			}
			if(_resultadosSolucion.get("f" + i) > 9) {
				System.out.println(" " +  _resultadosSolucion.get("f" + i));
			}else {
				System.out.println("  " +  _resultadosSolucion.get("f" + i));
			}
		}
		
		for(int j = 0; j < _tamanio ; j++) {
			if(_resultadosSolucion.get("c" + j) > 9) {
				System.out.print(" " +  _resultadosSolucion.get("c" + j));
			}else {
				System.out.print("  " +  _resultadosSolucion.get("c" + j));
			}
		}
		System.out.println("");
	}

	/*
	 * -------------- Metodos Privados ----------------
	 */
	
	/*
	 * Este metodo seria mejor que lo hagamos que generar grilla vacia y por separado la del resultado
	 */
	private int[][] generarGrilla(int tamanio) {
		for(int i=0; i < _tamanio; i++) {
			_resultados.put("f" + i, 0);
			_resultados.put("c" + i, 0);
		}
		return new int[tamanio][tamanio];
	}
	
	
	private int[][] generarGrillaSolucion(int tamanio) {
		int[][] grilla = new int[tamanio][tamanio];
		
		for(int i = 0; i < tamanio ; i++) {
			_resultadosSolucion.put("f" + i, 0);
			_resultadosSolucion.put("c" + i, 0);
		}
		/*
		 * Creo que aca hay un error en el diccionario en los indices en la parte de las columnas, tendria que ir j no i creo.
		 */
		
		for(int i = 0; i < tamanio; i++) {
			for(int j = 0; j < tamanio; j++) {
				// Genero la grilla random
				grilla[i][j] = rand(1,tamanio*2);
				
				// Sumando a cada fila
				_resultadosSolucion.put("f" + i, _resultadosSolucion.get("f"+i) + grilla[i][j]);
				
				// Sumando a cada columna
				_resultadosSolucion.put("c" + i, _resultadosSolucion.get("c"+i) + grilla[i][j]);
				
			}
		
		}
		return grilla;
	}
	
	
	private static int rand(int min, int max) {
		Random r = new Random(); 
		return r.nextInt(max-min+1) + min;
	}
	
	private int obtenerResultado(String fila_o_col, int i) {
		if(fila_o_col.equals("f") || fila_o_col.equals("c")) {
			if(i >= 0 && i < _tamanio) {
				return _resultados.get(fila_o_col + i);
			}else {
				throw new IllegalArgumentException("El numero de fila o columan debe estar en el rango: " + i);
			}
		}else {
			throw new IllegalArgumentException("Debe introducir f - fila o ' - columna: " + fila_o_col);
		}
	}
}
