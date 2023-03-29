package frontend;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaInGame extends JFrame {

	private JPanel contentPane;
	JButton iniciar;
	private JButton rendirse;
	private JPanel Grilla;
	private JTextField[][] matriz;
	private Juego __juego__;
	
	private static int TAMANIO = 2;
	private static Color COLORFONDO = new Color(0, 0, 51);
	
	public VentanaInGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(COLORFONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciar = new JButton("Iniciar");
		iniciar.setBounds(15, 11, 89, 34);
		iniciar.setFocusable(false);
		contentPane.add(iniciar);
		
		rendirse = new JButton("Rendirse");
		rendirse.setBounds(114, 11, 89, 34);
		rendirse.setFocusable(false);
		rendirse.setEnabled(false);
		contentPane.add(rendirse);
						
		iniciar.addActionListener(new AccionesIniciar());
		rendirse.addActionListener(new AccionesRendirse());
	}

	private void crearGrilla(int tamanio) {
		// Si la grilla no es nula tengo que remover la anterior
		if(Grilla != null) {
			contentPane.remove(Grilla);
		}
		matriz = new JTextField[tamanio][tamanio];
		Grilla = new JPanel();
		Grilla.setVisible(false); // Evito que se vea
		Grilla.setOpaque(false);
		Grilla.setBounds(15, 69, 750, 476);
		contentPane.add(Grilla);
		Grilla.setLayout(new GridLayout(tamanio, tamanio, 20, 20));

		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				JTextField celda = new JTextField();
				celda.setColumns(10); // No se que hace lo puso window builder
				celda.setFont(new Font("Helvetica", Font.BOLD, 30));
				celda.setHorizontalAlignment(SwingConstants.CENTER);
				
				if (i == tamanio-1 && j == tamanio-1) {
					// Estoy en la esquina derecha inferior. No la quiero mostrar
					celda.setVisible(false);
				}else if (i == tamanio - 1 || j == tamanio - 1) {
					// Las ultima fla y la ultima columna se pintan en rojo.
					celda.setBackground(Color.RED);
					celda.setForeground(Color.WHITE);
					celda.setEditable(false);
				}else {
					// Si no son las ultimas les agrego interaccion
					celda.addKeyListener(new AccionesCelda(celda,i,j));
				}

				matriz[i][j] = celda;
				Grilla.add(celda);
			}
		}
	}

	// Usar celda en ves de JTextField;
	@SuppressWarnings({ "unused" })
	private class Celda extends JTextField {

		Tupla _posicion;

		public Celda(int x, int y) {
			_posicion = new Tupla(x, y);
		}

		public int getInt() {
			try {
				return Integer.valueOf(getText());
			} catch (Exception e) {
				return 0;
			}
		}

	}

	private class Tupla {
		private int _x, _y;
		public Tupla(int x, int y) {_x = x; _y = y;}
		@SuppressWarnings("unused")
		public int getX() {return _x;}
		@SuppressWarnings("unused")
		public int getY() { return _y;}
	}

	private class AccionesCelda implements KeyListener {
		/*
		 * Celda _celda; public accionesCelda(Celda celda){}
		 * 
		 * 
		 */
		JTextField _celda;
		int _fila;
		int _columna;

		public AccionesCelda(JTextField celda,int fila,int columna) {
			super();
			if (celda != null) {
				_celda = celda;
				_fila = fila;
				_columna = columna;
			} else {
				throw new IllegalArgumentException("Debe pasar una celda como parametro");
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean esNumero = (key >= 49) && (key <= 57);
			if (!esNumero || _celda.getText().length() > 0) {
				e.consume();
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
		// Al soltar la tecla se ejecuta este evento.	
			if(__juego__ != null) 
			{   
				if(_celda.getText().length() != 0) {
					__juego__.ingresoNumeroEnGrillaJuego(_fila,_columna,Integer.valueOf(_celda.getText()) );
					System.out.println("Se ingreso el numero " + _celda.getText() + " en la posicion (" + _fila +","+ _columna +")." );
				}else {
					__juego__.ingresoNumeroEnGrillaJuego(_fila,_columna,0);
				}
				if(__juego__.gano()) {
					frenarTodo();
					jugadorGano();
				}
			}
		}
	}
	
	private class AccionesIniciar implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Creo la Grilla GUI para el usuario.
			crearGrilla(TAMANIO+1);
			
			// Inicia la instancia de Juego. Creo la grilla logica.
			__juego__ = new Juego(TAMANIO);

			// Carga a la grilla los valores de la instancia de Juego
			cargarValoresAlaGrilla();
			
			// Muestro la grilla
			Grilla.setVisible(true);
			
			// Deshabilita la opcion del boton
			iniciar.setEnabled(false);
			
			// Habilito la opcion de rendirse
			rendirse.setEnabled(true);
		}

		private void cargarValoresAlaGrilla() {
			if(__juego__ != null) {
				// Carga los valores en las casillas rojas.
				for(int indice=0; indice < matriz.length-1; indice++) {
					matriz[matriz.length-1][indice].setText("" + __juego__.obtenerResultadosSolucion("c", indice));
					matriz[indice][matriz.length-1].setText("" + __juego__.obtenerResultadosSolucion("f", indice));
					
				}
			}
		}
		
	}
	
	
	private class AccionesRendirse implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Freno el juego
			frenarTodo();
			
			// Explicar al usuario
			mensajeRendirse();
			
			// Cargo una posible Solucion
			cargarSolucion();
			
			// Deshabilito rendirse
			rendirse.setEnabled(false);
			
			// Habilito iniciar
			iniciar.setEnabled(true);
		}

		private void mensajeRendirse() {
			JOptionPane.showMessageDialog(getContentPane(), "Usted se ha rendido. A continuacion se mostrara una solucion.");
		}

		private void cargarSolucion() {
			if(__juego__ != null) {
				for(int fila=0; fila < matriz.length-1; fila++) {
					for(int columna=0; columna < matriz.length-1; columna++) {
						matriz[fila][columna].setText("" + __juego__.obtenerValoresGrillaSolucion(fila, columna));
					}
				}
				Grilla.setVisible(true);
			}
			
		}
		
	}
	
	private void frenarTodo() {
		Grilla.setVisible(false);
		
	}
	
	private void jugadorGano() {
		JOptionPane.showMessageDialog(getContentPane(), "Usted a ganado.");
		iniciar.setEnabled(true);
		rendirse.setEnabled(false);
	}
	
	
	
	public static void main(String[] args) {
		VentanaInGame v = new VentanaInGame();
		v.setVisible(true);
	}
}
