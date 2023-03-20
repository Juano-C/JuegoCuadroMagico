package visualizacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel f0;
	private JLabel f1;
	private JLabel f2;
	private JLabel f3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaPrueba frame = new VentanaPrueba();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrueba() {
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();

		textField.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Helvetica", Font.BOLD, 30));
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		
		JPanel grilla_jugador = FabricaComponentes.crearGrilla(Color.LIGHT_GRAY, textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13, textField_14, textField_15);
		grilla_jugador.setBounds(10, 11, 541, 418);
		contentPane.add(grilla_jugador);
		
		
		
		JPanel resultados_fila = new JPanel();
		resultados_fila.setBackground(Color.LIGHT_GRAY);
		resultados_fila.setBounds(561, 11, 135, 418);
		contentPane.add(resultados_fila);
		resultados_fila.setLayout(new GridLayout(4, 1, 0, 20));
		
		f0 = new JLabel("9");
		f0.setOpaque(true);
		f0.setHorizontalAlignment(SwingConstants.CENTER);
		f0.setForeground(Color.WHITE);
		f0.setFont(new Font("Helvetica", Font.BOLD, 30));
		f0.setBackground(Color.DARK_GRAY);
		resultados_fila.add(f0);
		
		f1 = new JLabel("9");
		f1.setOpaque(true);
		f1.setHorizontalAlignment(SwingConstants.CENTER);
		f1.setForeground(Color.WHITE);
		f1.setFont(new Font("Helvetica", Font.BOLD, 30));
		f1.setBackground(Color.DARK_GRAY);
		resultados_fila.add(f1);
		
		f2 = new JLabel("9");
		f2.setOpaque(true);
		f2.setHorizontalAlignment(SwingConstants.CENTER);
		f2.setForeground(Color.WHITE);
		f2.setFont(new Font("Helvetica", Font.BOLD, 30));
		f2.setBackground(Color.DARK_GRAY);
		resultados_fila.add(f2);
		
		f3 = new JLabel("9");
		f3.setOpaque(true);
		f3.setHorizontalAlignment(SwingConstants.CENTER);
		f3.setForeground(Color.WHITE);
		f3.setFont(new Font("Helvetica", Font.BOLD, 30));
		f3.setBackground(Color.DARK_GRAY);
		resultados_fila.add(f3);
		
		JPanel resultados_columna = new JPanel();
		resultados_columna.setBackground(Color.LIGHT_GRAY);
		resultados_columna.setBounds(10, 440, 541, 86);
		contentPane.add(resultados_columna);
		resultados_columna.setLayout(new GridLayout(1, 4, 20, 0));
		
		JLabel c0 = new JLabel("9");
		c0.setFont(new Font("Helvetica", Font.BOLD, 30));
		c0.setBackground(Color.DARK_GRAY);
		c0.setOpaque(true);
		c0.setForeground(Color.WHITE);
		c0.setHorizontalAlignment(SwingConstants.CENTER);
		resultados_columna.add(c0);
		
		JLabel c1 = new JLabel("9");
		c1.setFont(new Font("Helvetica", Font.BOLD, 30));
		c1.setBackground(Color.DARK_GRAY);
		c1.setOpaque(true);
		c1.setForeground(Color.WHITE);
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		resultados_columna.add(c1);
		
		JLabel c2 = new JLabel("9");
		c2.setFont(new Font("Helvetica", Font.BOLD, 30));
		c2.setBackground(Color.DARK_GRAY);
		c2.setOpaque(true);
		c2.setForeground(Color.WHITE);
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		resultados_columna.add(c2);
		
		JLabel c3 = new JLabel("9");
		c3.setFont(new Font("Helvetica", Font.BOLD, 30));
		c3.setBackground(Color.DARK_GRAY);
		c3.setOpaque(true);
		c3.setForeground(Color.WHITE);
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		resultados_columna.add(c3);
	
		System.out.println("haaaaa");
		
	}
	

}
