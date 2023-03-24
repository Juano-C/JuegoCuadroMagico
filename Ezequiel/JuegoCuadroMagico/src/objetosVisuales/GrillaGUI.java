package objetosVisuales;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GrillaGUI extends JPanel{
	
	
	/*
	 * Atributos 
	 */

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int _filas;
	int _columnas;
	JTextField[][] _celdasDeLaGrilla;
	JPanel _resultados_fila;
	JPanel _resultados_columna;
	
	
	public GrillaGUI(int n, int m) {
		_filas = n;
		_columnas = m;
		disenioPanel();
		crearGrilla();

	}


	private void disenioPanel() {
		setVisible(true);
		setBounds(10, 11, 541, 418); // Creando el panel para la grilla 
		setLayout(new GridLayout(_filas,_columnas, 20, 20)); // Subdivision del panel en filas x coluumnas
		setOpaque(true); // La opacidad del panel se superpone
		setBackground(Color.lightGray);
	}
	

	private void crearGrilla() {
		_celdasDeLaGrilla = new JTextField[_filas][_columnas];
		for(int filaIndice=0; filaIndice < _celdasDeLaGrilla.length; filaIndice++) {
			

			for(int columnaIndice=0; columnaIndice < _celdasDeLaGrilla[0].length; columnaIndice++) {
				
				if(filaIndice == _celdasDeLaGrilla[0].length-1 && _celdasDeLaGrilla[0].length-1==columnaIndice ) {
					continue;
				}
				JTextField celdaDeTexto = new JTextField(); // Creo cada cuadrito de texto (JTextFields)
				
				disenioCeldaNormal(celdaDeTexto);
				if(_celdasDeLaGrilla[0].length-1==columnaIndice || _celdasDeLaGrilla[0].length-1==filaIndice) {
					celdaDeTexto.setEditable(false);
					if(filaIndice == _celdasDeLaGrilla[0].length-1 && _celdasDeLaGrilla[0].length-1==columnaIndice ) {
						celdaDeTexto.setBackground(Color.LIGHT_GRAY);
					}else {
						celdaDeTexto.setBackground(Color.CYAN);

					}
				}
//				celdaDeTexto.setColumns(10);
				this.add(celdaDeTexto); // Agrega la celda dee texto a el panel.
				_celdasDeLaGrilla[filaIndice][columnaIndice] = celdaDeTexto;
				

			}
			
		}
	}


	private void disenioCeldaNormal(JTextField celdaDeTexto) {
		celdaDeTexto.setFont(new Font("Helvetica", Font.BOLD, 30)); // Seteamos la fuente
		celdaDeTexto.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
//	private void disenioCeldaResultado(JLabel celdaDeTexto) {
//		celdaDeTexto.setFont(new Font("Helvetica", Font.BOLD, 30)); // Seteamos la fuente
//		celdaDeTexto.setHorizontalAlignment(SwingConstants.CENTER);
//	}

	@Override
	public void repaint() {
		super.repaint();
	}
		
	public static void main(String[] args) {
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
