package frontend;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.Controlador;
import disenio.DisenioBoton;
import disenio.IconoCerrarVentana;
import fileManager.ManipuladorArchivos;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

@SuppressWarnings("serial")
public class VentanaRecord extends JFrame {


	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel Tiempos;
	private JTable table;
	private JLabel iconoXcerrar;

	public static void main(String[] args) {
		VentanaRecord a = new VentanaRecord();
		a.setVisible(true);
	}
	
	public VentanaRecord() {
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
		
		Tiempos = new JLabel("Tiempos");
		Tiempos.setForeground(new Color(255, 255, 255));
		Tiempos.setFont(new Font("Tahoma", Font.BOLD, 15));
		Tiempos.setHorizontalAlignment(SwingConstants.CENTER);
		Tiempos.setBounds(310, 59, 146, 37);
		getContentPane().add(Tiempos);
		
		//--------------boton Volver
		JButton botonVolver = new JButton("Volver");
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.abrirVentanaMain();


			}
		});
		botonVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonVolver.setBackground(new Color(0, 0, 51));
		botonVolver.setBounds(20, 412, 123, 27);
		botonVolver.setFocusable(false);
		botonVolver.addMouseListener(new DisenioBoton(botonVolver));
		getContentPane().add(botonVolver);
		
		/*
		 * --------- Icono cerrar ventana ----------------
		 */
		iconoXcerrar = new IconoCerrarVentana();
		iconoXcerrar.setBounds(447, 0, 39, 34);
		getContentPane().add(iconoXcerrar);
		
		
		/*
		 * Aca agregas los campos y las columnas
		 */
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"1", "Lola", "22"},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				"Puesto", "Nombre", "Tiempo"
//			}
//		) {
//			@SuppressWarnings("rawtypes")
//			Class[] columnTypes = new Class[] {
//				Object.class, Object.class, String.class
//			};
//			@SuppressWarnings({ "unchecked", "rawtypes" })
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//			boolean[] columnEditables = new boolean[] {
//				true, true, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		table.getColumnModel().getColumn(2).setResizable(false);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 51));
		table.setBounds(20, 107, 442, 294);
		table.setShowGrid(false);
		getContentPane().add(table);
		
		actualizarTabla();
		
//		String columnas[]={"Puesto","Nombre","Apellido"};
//		String filas[][]={{"1","Pee","Leo"},{"2","Caa","til"}};
//		@SuppressWarnings("unused")
//		DefaultTableModel modeloTabla= new DefaultTableModel(filas,columnas);
	}
		
		
	private void actualizarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Puestp");
        model.addColumn("Nombre");
        model.addColumn("Tiempo");

//        model.addRow(new Object[]{"1","Computadora","$ 5000"});
//        model.addRow(new Object[]{"2","Computadora","$ 7000"});
//        model.addRow(new Object[]{"3","Computadora","$ 4000"});
//        model.addRow(new Object[]{"4","Computadora","$ 1000"});
//        model.addRow(new Object[]{"5","Computadora","$ 500"});
//        model.addRow(new Object[]{"6","Computadora","$ 2000"});

		Map<Integer, String> lineasTXT = ManipuladorArchivos.lineasDeText();
        
        for(int i=1; i <= 18; i++) {
        	try {
            	String nombre = lineasTXT.get(i).split("-")[1];
            	String tiempo = lineasTXT.get(i).split("-")[0];
            	model.addRow(new Object[] {i, nombre, tiempo});
			} catch (Exception e) {
				model.addRow(new Object[] {i, "", ""});
			}
        }
        
        table.setModel(model);
	}
}
