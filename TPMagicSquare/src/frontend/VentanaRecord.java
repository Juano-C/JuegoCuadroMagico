package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controladores.Controlador;
import disenio.IconoCerrarVentana;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class VentanaRecord extends JFrame {


	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTable table;
	private JLabel iconoXcerrar;

	public VentanaRecord() {
		initialize();
	}

	private void initialize() {
//		marcoPrincipal = new JFrame();
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 51));
		setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
		setTitle("Records");
		setForeground(new Color(0, 128, 64));
		setBounds(100, 100, 486, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		initComponentes();
	}
//	public void VentanaRecord() {
//		
//		setUndecorated(true);
//		getContentPane().setBackground(new Color(0, 0, 51));
//		setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
//		setTitle("Records");
//		setForeground(new Color(0, 128, 64));
//		setBounds(100, 100, 486, 450);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		getContentPane().setLayout(null);
//		setLocationRelativeTo(null);
//		initComponentes();
//		
//	}
		private void initComponentes() {
		JLabel lblNewLabel = new JLabel("Puntajes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 11, 410, 37);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Puesto");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 59, 96, 37);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(142, 59, 144, 37);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Puntaje");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(310, 59, 146, 37);
		getContentPane().add(lblNewLabel_3);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		/*
		 * Aca agregas los campos y las columnas
		 */
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Lola", "22"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Puesto", "Nombre", "Tiempo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 51));
		table.setBounds(20, 107, 442, 286);
		getContentPane().add(table);
		
		//--------------boton Volver
		JButton botonVolver = new JButton("Volver");
		botonVolver.setForeground(new Color(0, 0, 0));
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.abrirVentanaMain();


			}
		});
		botonVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonVolver.setBackground(new Color(128, 255, 128));
		botonVolver.setBounds(20, 412, 123, 27);
		getContentPane().add(botonVolver);
		
		/*
		 * --------- Icono cerrar ventana ----------------
		 */
		iconoXcerrar = new IconoCerrarVentana();
		iconoXcerrar.setBounds(447, 0, 39, 34);
		getContentPane().add(iconoXcerrar);
		
		String columnas[]={"Puesto","Nombre","Apellido"};
		String filas[][]={{"1","Pee","Leo"},{"2","Caa","til"}};
		DefaultTableModel modeloTabla= new DefaultTableModel(filas,columnas);
	}
}
