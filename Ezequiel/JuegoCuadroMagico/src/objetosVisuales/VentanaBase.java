package objetosVisuales;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaBase extends JFrame {
	
	public VentanaBase() {
		// Tama�os
		super();
		setVisible(true);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 554);
		
		// ContentePane
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new GrillaGUI(8,8);
		panel.setBounds(10, 11, 659, 464);
		contentPane.add(panel);
		
		
	}
	
	public static void main(String[] args) {
		VentanaBase b = new VentanaBase();
		b.setVisible(true);
		
	}
}
