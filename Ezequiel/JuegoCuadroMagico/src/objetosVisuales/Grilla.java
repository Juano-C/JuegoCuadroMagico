package objetosVisuales;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Grilla extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int _filas;
	int _columnas;
	JTextField[] _cuadritos;
	JPanel _resultados_fila;
	JPanel _resultados_columna;
	
	
	public Grilla(int n, int m) {
		_filas = n;
		_columnas = m;
		setVisible(true);
		setBounds(10, 11, 541, 418);
		setLayout(new GridLayout(_filas,_columnas, 20, 20));
		setOpaque(true);
		setBackground(Color.lightGray);
		crearGrilla();

	}
	

	private void crearGrilla() {
		_cuadritos = new JTextField[_filas*_columnas];
		for(int i=0; i < _cuadritos.length; i++) {
			JTextField textField = new JTextField();
			textField.setFont(new Font("Helvetica", Font.BOLD, 30));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setColumns(10);
			this.setBounds(10, 11, 541, 418);
			this.add(textField);
			_cuadritos[i] = textField;
		}
	}

	@Override
	public void repaint() {
		super.repaint();
	}
		
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
