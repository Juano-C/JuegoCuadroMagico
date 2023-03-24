package backend;

import javax.swing.JPanel;

public class GrillaJuego extends JPanel
{
    private int[][] _grilla;
    private int[][] _grillaSol;
    private int _tamanio;

    //constructor
    public GrillaJuego(int[][] grilla, int[][] grillaSol, int tamanio)
    {
        if(tamanio <=0)
            throw new IllegalArgumentException("El tamanio debe ser un entero positivo: " + tamanio);
        _grilla = grilla;
        _grillaSol = grillaSol;
        _tamanio = tamanio;
    }

    private  void agregarNumero(int fila, int columna, int numeroAgregado)
    {
        verificacionIngresoNumeros(numeroAgregado, fila, columna);
        _grilla[fila][columna] = numeroAgregado;
    }

    private void verificacionIngresoNumeros(int numeroAgregado, int fila, int columna)
    {
        if(numeroAgregado<=-1 || numeroAgregado>=100)
            throw new IllegalArgumentException("El numero ingresado debe estar entre 0 y 99: " + numeroAgregado);
        if(fila < _tamanio || columna < _tamanio)
            throw new IllegalArgumentException("La posicion ingresada es invalida: "+"[" + fila+","+columna+"]" );
    }

	public void imprimir() {
		// TODO Auto-generated method stub
		
	}

	public void modificar(int i, int j, int num) {
		// TODO Auto-generated method stub
		
	}
}
