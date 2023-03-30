package disenio;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controladores.Controlador;
import juego.Juego;

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
		int i_fila = 0;
		int j_col = 0;
		for(int filaIndice=0; filaIndice < _celdasDeLaGrilla.length; filaIndice++) {
			

			for(int columnaIndice=0; columnaIndice < _celdasDeLaGrilla[0].length; columnaIndice++) {
				
				if(filaIndice == _celdasDeLaGrilla[0].length-1 && _celdasDeLaGrilla[0].length-1==columnaIndice ) {
					continue;
				}
				Celda celdaDeTexto = new Celda(filaIndice,columnaIndice); // Creo cada cuadrito de texto (JTextFields)
				
				disenioCeldaNormal(celdaDeTexto);
				if(_celdasDeLaGrilla[0].length-1==columnaIndice || _celdasDeLaGrilla[0].length-1==filaIndice) {
					celdaDeTexto.setEditable(false);
					if(filaIndice == _celdasDeLaGrilla.length-1 && _celdasDeLaGrilla[0].length-1==columnaIndice ) {
						celdaDeTexto.setBackground(Color.LIGHT_GRAY);
					}else {
						
						if(i_fila < _celdasDeLaGrilla.length - 1) {
							celdaDeTexto.setText(Integer.toString(Controlador.obtenerResultadosSolucion("f", i_fila)));
							i_fila++;
						}
						
						else {
							celdaDeTexto.setText(Integer.toString(Controlador.obtenerResultadosSolucion("c", j_col)));
							j_col++;
						}
;
						celdaDeTexto.setBackground(Color.red);
						celdaDeTexto.setForeground(Color.white);

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
	
	
	private class Celda extends JTextField{
		
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private class MyListeners implements KeyListener{

			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean esNumero = (key >= 49) && (key <= 57);
				if(!esNumero || getText().length() > 0) {
					e.consume();
				}

			}
			
			

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Controlador.ingresoNumeroEnGrillaJuego(fila, columna, getInt());
					System.out.println("Se ingreso el numero " +  getInt());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
	
				Controlador.ingresoNumeroEnGrillaJuego(fila, columna, getInt());
				System.out.println("Se ingreso el numero " +  getInt() + " en la poisicion " + "(" + fila + "," + columna + ")");
//				_juego.imprimir();
			}
			
			
		}
		
		private int fila, columna;
		
		public Celda(int i, int j) {
			super();
			// condicion para evitar las filas y columnas q no son parte de la grilla	  
			addKeyListener(new MyListeners());
			
			fila = i;
			columna = j;
		}
		
		public int[] getIndice() {
			int[] indices = new int[2];
			indices[0] = fila;
			indices[1] = columna;
			return indices;
		}
		
		/*
		 * Devuelve el entero en la posicion solictada
		 */	
		public int getInt() {
			int num;
			try {
				num = Integer.parseInt(getText());
			} catch (Exception e) {
				return 0;
			}
			return num;
		}
		
	}
	
	@Override
	public void repaint() {
		super.repaint();
	}
	
}
