package frontend;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controladores.Controlador;
import disenio.DisenioBoton;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaCargarRecord extends JFrame {

	private JFrame frame;
	private JTextField nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCargarRecord window = new VentanaCargarRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCargarRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		fabricaInterfaz.setVentana(frame, "Record",  100, 100, 486, 450,new Color(0, 0, 51));
		
		
		/*
		 * Icono cerrar ventana 
		 */
		JLabel iconoXcerrar = fabricaInterfaz.crearBotonCerrar(447, 0, 39, 34);
		
		frame.getContentPane().add(iconoXcerrar);
		
		
		
		/*
		 * Felicidades
		 */
		JLabel felicidades = fabricaInterfaz.crearLabelEstiloRecordCarga(23, 50, 450, 50, "!!FELICIDADES USTED HA GANADO¡¡");
				
				/*new JLabel("!!FELICIDADES USTED HA GANADO¡¡");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 11, 426, 50);*/
		
		frame.getContentPane().add(felicidades);
		/*
		 * Texto 
		 */
		JLabel suRecord = fabricaInterfaz.crearLabelEstiloRecordCarga(150, 116, 200, 31, "SU RECORD ES :");
				/*new JLabel("SU RECORD ES :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(154, 116, 190, 31);*/
		frame.getContentPane().add(suRecord);
		
		nombre = new JTextField();
		nombre.setBounds(154, 219, 175, 45);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		/*
		 * Boton de subida 
		 */
		JButton botonSubida = fabricaInterfaz.crearBoton("SUBIR", 154, 280, 175, 45);
				/*new JButton("AGREGAR");
				botonSubida.setBounds(154, 280, 157, 45);*/
		fabricaInterfaz.cambiarTamanioFuente(botonSubida, 23);
		botonSubida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.cargarNombre(nombre.getText());
				nombre.setText("");
				Controlador.abrirVentana(Controlador.getVentanaMain(), frame);
			}
		});
		botonSubida.addMouseListener(new DisenioBoton(botonSubida) );
		frame.getContentPane().add(botonSubida);
		/*
		 * Boton de continuar
		 */
		JButton botonIrIinicio = fabricaInterfaz.crearBoton("CONTINUAR", 154, 355, 175, 45);
			
		fabricaInterfaz.cambiarTamanioFuente(botonIrIinicio, 23);
		/*	
				new JButton("CONTINUAR");
				botonIrIinicio.setBounds(173, 355, 117, 45);*/
		botonIrIinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText("");
				Controlador.abrirVentana(Controlador.getVentanaMain(), frame);
			}
		});
		
		botonIrIinicio.addMouseListener(new DisenioBoton(botonIrIinicio) );
		frame.getContentPane().add(botonIrIinicio);
		/*
		 * Label para poner el tiempo 
		 */
		JLabel record =fabricaInterfaz.crearLabelEstiloRecordCarga(195, 158, 87, 50, "11:11:11");
				/*new JLabel("11:11:11");
		record.setFont(new Font("Tahoma", Font.PLAIN, 20));
		record.setBounds(191, 158, 87, 50);*/
		frame.getContentPane().add(record);
	}
}
