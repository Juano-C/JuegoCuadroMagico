package visualizacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ventanaRecord {

	private JFrame marcoPrincipal;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaRecord window = new ventanaRecord();
					window.marcoPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		marcoPrincipal = new JFrame();
		marcoPrincipal.getContentPane().setBackground(new Color(153, 204, 255));
		marcoPrincipal.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
		marcoPrincipal.setTitle("Records");
		marcoPrincipal.setForeground(new Color(0, 128, 64));
		marcoPrincipal.setBounds(100, 100, 450, 300);
		marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puntajes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Goudy Stout", Font.BOLD, 15));
		lblNewLabel.setBounds(85, 11, 263, 37);
		marcoPrincipal.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Puesto");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Goudy Stout", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 45, 106, 37);
		marcoPrincipal.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Goudy Stout", Font.BOLD, 12));
		lblNewLabel_2.setBounds(126, 45, 144, 37);
		marcoPrincipal.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Puntaje");
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Goudy Stout", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(262, 45, 146, 37);
		marcoPrincipal.getContentPane().add(lblNewLabel_3);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Goudy Stout", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Lola", "22"},
				{"2", "Juan", "22"},
				{"3", "Maria", "33"},
				{"4", "", null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBackground(new Color(153, 204, 255));
		table.setForeground(new Color(0, 0, 51));
		table.setBounds(34, 93, 390, 157);
		marcoPrincipal.getContentPane().add(table);
		
		
		String columnas[]={"Puesto","Nombre","Apellido"};
		String filas[][]={{"1","Pee","Leo"},{"2","Caa","til"}};
		DefaultTableModel modeloTabla= new DefaultTableModel(filas,columnas);
	}
}
