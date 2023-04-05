package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controladores.Controlador;
import disenio.DisenioBoton;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaCargarRecord extends  JFrame {

	private JFrame frame;
	private JTextField nombre;
	private JButton botonSubida ;
	private JPanel contentPane;
	JLabel felicidades;
	JLabel iconoXcerrar;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		Controlador.abrirVentana(Controlador.getVentanaCargarRecord(),Controlador.getVentanaDificultad());
	}

	/**
	 * Create the application.
	 */
	public VentanaCargarRecord() {
		
		//super();
		setUndecorated(true);
		initialize();
		
		//setUndecorated(true);
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		 contentPane = new JPanel();
		setContentPane(contentPane);
		setVisible(true);
		fabricaInterfaz.setVentana(this, "Record",  100, 100, 486, 450,new Color(0, 0, 51));
		
		
		
		/*
		 * Icono cerrar ventana 
		 */
		 iconoXcerrar = fabricaInterfaz.crearBotonCerrar(447, 0, 39, 34);
		
		contentPane.add(iconoXcerrar);
		
		/*
		 * Felicidades
		 */
		 felicidades = fabricaInterfaz.crearLabelEstiloRecordCarga(23, 50, 450, 50, "!!FELICIDADES USTED HA GANADO¡¡");
		contentPane.add(felicidades);
		/*
		 * Texto 
		 */
		JLabel suRecord = fabricaInterfaz.crearLabelEstiloRecordCarga(150, 116, 200, 31, "SU RECORD ES :");
		contentPane.add(suRecord);
		nombre = new JTextField();
		nombre.setBounds(154, 219, 175, 45);
		
		nombre.setColumns(10);
		contentPane.add(nombre);
		/*
		 * Boton de subida 
		 */
		JButton botonSubida = fabricaInterfaz.crearBoton("SUBIR", 154, 280, 175, 45);
				/*new JButton("AGREGAR");
				botonSubida.setBounds(154, 280, 157, 45);*/
		//fabricaInterfaz.cambiarTamanioFuente(botonSubida, 23);
		
		botonSubida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.cargarNombre(nombre.getText());
				nombre.setText("");
				Controlador.abrirVentana(Controlador.getVentanaMain(), frame);
			}
		});
		
		botonSubida.addMouseListener(new DisenioBoton(botonSubida) );
		contentPane.add(botonSubida);
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
		contentPane.add(botonIrIinicio);
		/*
		 * Label para poner el tiempo 
		 */
		JLabel record =fabricaInterfaz.crearLabelEstiloRecordCarga(195, 158, 87, 50, "11:11:11");
		contentPane.add(record);
		
		
		
	}
}
