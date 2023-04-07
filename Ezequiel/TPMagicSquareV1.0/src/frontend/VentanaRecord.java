package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controladores.Controlador;
import disenio.DisenioBoton;
import fileManager.ManipuladorArchivos;

@SuppressWarnings("serial")
public class VentanaRecord extends JFrame {

	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTable table;
	private JLabel iconoXcerrar;
	private JButton botonVolver;
	
	public VentanaRecord() {

		fabricaInterfaz.setVentana(this, "Records", 100, 100, 486, 450, new Color(0, 0, 51));
		setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
		setForeground(new Color(0, 128, 64));
		setUndecorated(true);
		initComponentes();		
	}

	private void initComponentes() {
		JLabel lblNewLabel = fabricaInterfaz.crearLabelEstiloRecord(20, 11, 410, 37, "Puntajes");
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = fabricaInterfaz.crearLabelEstiloRecord(20, 59, 96, 37, "Puesto");
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = fabricaInterfaz.crearLabelEstiloRecord(142, 59, 144, 37, "Nombre");
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = fabricaInterfaz.crearLabelEstiloRecord(310, 59, 146, 37, "Puntaje");
		getContentPane().add(lblNewLabel_3);

		/* ----------- CREACION DE LA TABLA DE RECORDS ----------- */
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 51));
		table.setBounds(20, 107, 442, 294);
		table.setShowGrid(false);
		getContentPane().add(table);

//		actualizarTabla();

		// --------------boton Volver
		botonVolver = fabricaInterfaz.crearBoton("Volver", 20, 412, 123, 27);
		botonVolver.setHorizontalAlignment(SwingConstants.CENTER);
		fabricaInterfaz.cambiarTamanioFuente(botonVolver, 20);
		botonVolver.addMouseListener(new DisenioBoton(botonVolver));
		botonVolver.setBackground(new Color(0, 0, 51));
		botonVolver.setFocusable(false);
		getContentPane().add(botonVolver);
		botonVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.reproducirClick();
				Controlador.abrirVentana(Controlador.getVentanaMain(), Controlador.getVentanaRecords());
			}
		});

		/*
		 * --------- Icono cerrar ventana ----------------
		 */
		iconoXcerrar = fabricaInterfaz.crearBotonCerrar(447, 0, 39, 34);
		getContentPane().add(iconoXcerrar);
		
		
	}

	private void actualizarTabla() {
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Puestp");
		model.addColumn("Nombre");
		model.addColumn("Tiempo");

		Map<Integer, String> lineasTXT = ManipuladorArchivos.lineasDeText();

		for (int i = 1; i <= 18; i++) {
			try {
				String nombre = lineasTXT.get(i).split("-")[1];
				String tiempo = lineasTXT.get(i).split("-")[0];
				model.addRow(new Object[] { i, nombre, tiempo });
			} catch (Exception e) {
				model.addRow(new Object[] { i, "", "" });
			}
		}

		table.setModel(model);
	}
	

	/**
	 * Cada ves que se muestra esta ventana actualizo la tabla de posiciones.
	 */
	@Override
	public void setVisible(boolean b) {
		actualizarTabla();
		super.setVisible(b);
	}
}
