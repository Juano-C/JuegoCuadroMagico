package frontend;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaDificultad extends JFrame {

    public VentanaDificultad() {
        // Tama�os
        super();
        setUndecorated(true);
        setTitle("Cuadro Magico");
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);

        //-------------------ContentePane
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //-------------------Boton de facil
        JButton btnFacil = new JButton("Facil");
        btnFacil.setFocusable(false);
        btnFacil.setForeground(new Color(255, 255, 255));
        btnFacil.setBorderPainted(false);
        btnFacil.setBackground(new Color(0, 0, 51));
        btnFacil.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnFacil.setBounds(59, 100, 114, 34);
        contentPane.add(btnFacil);

        //-------------------Boton de medio
        JButton btnMedio = new JButton("Medio");
        btnMedio.setFocusable(false);
        btnMedio.setBackground(new Color(0, 0, 51));
        btnMedio.setBorderPainted(false);
        btnMedio.setForeground(new Color(255, 255, 255));
        btnMedio.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnMedio.setBounds(59, 188, 114, 34);
        contentPane.add(btnMedio);

        //-------------------Boton de dificil
        JButton btnDificil = new JButton("Dificil");
        btnDificil.setFocusable(false);
        btnDificil.setBackground(new Color(0, 0, 51));
        btnDificil.setBorderPainted(false);
        btnDificil.setForeground(new Color(255, 255, 255));
        btnDificil.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnDificil.setBounds(59, 276, 114, 34);
        contentPane.add(btnDificil);

        //-------------------Boton salir pantalla de dificultad
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setBackground(new Color(255, 255, 255));
        btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
        btnSalir.setFont(new Font("Serif", Font.PLAIN, 15));
        btnSalir.setBounds(495, 421, 75, 29);
        contentPane.add(btnSalir);

        //-------------------Boton de Atras
        JButton btnAtras = new JButton("Atras");
        btnAtras.setFocusable(false);
        btnAtras.setBackground(new Color(255, 255, 255));
        btnAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 VentanaMain ventanaDificultad = new VentanaMain();
                 ventanaDificultad.setVisible(true);

                 ventanaDificultad.setLocationRelativeTo(null);

                 dispose();
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		VentanaMain ventanaDificultad = new VentanaMain();
                ventanaDificultad.setVisible(true);

                ventanaDificultad.setLocationRelativeTo(null);

                dispose();
        	}
        });
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                VentanaMain ventanaDificultad = new VentanaMain();
                ventanaDificultad.setVisible(true);

                ventanaDificultad.setLocationRelativeTo(null);

                dispose();
            }
            
        });
        btnAtras.setFont(new Font("Serif", Font.PLAIN, 15));
        btnAtras.setBounds(10, 421, 85, 29);
        contentPane.add(btnAtras);

        //-----------Textos de dificultad de grilla--------------
        JLabel lblNewLabel = new JLabel("Grilla de 3x3 con valores de 0 a 9");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        lblNewLabel.setBounds(230, 100, 271, 27);
        contentPane.add(lblNewLabel);

        JLabel lblGrillaDex = new JLabel("Grilla de 4x4 con valores de 0 a 20");
        lblGrillaDex.setForeground(new Color(255, 255, 255));
        lblGrillaDex.setFont(new Font("Serif", Font.PLAIN, 20));
        lblGrillaDex.setBounds(230, 188, 281, 27);
        contentPane.add(lblGrillaDex);
        
        JLabel lblGrillaDex_1 = new JLabel("Grilla de 5x5 con valores de 0 a 50");
        lblGrillaDex_1.setForeground(new Color(255, 255, 255));
        lblGrillaDex_1.setFont(new Font("Serif", Font.PLAIN, 20));
        lblGrillaDex_1.setBounds(230, 276, 281, 27);
        contentPane.add(lblGrillaDex_1);
        
        JLabel iconoXcerrar = new JLabel("X");
        iconoXcerrar.setOpaque(true);
        iconoXcerrar.setHorizontalAlignment(SwingConstants.CENTER);
        iconoXcerrar.setForeground(Color.WHITE);
        iconoXcerrar.setFont(new Font("Verdana", Font.BOLD, 18));
        iconoXcerrar.setBackground(new Color(0, 0, 51));
        iconoXcerrar.setBounds(561, 0, 39, 34);
        contentPane.add(iconoXcerrar);
		// Cerrar ventana
		iconoXcerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iconoXcerrar.setBackground(Color.red);
				iconoXcerrar.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				iconoXcerrar.setBackground(new Color(0, 0, 51));
				iconoXcerrar.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				iconoXcerrar.setBackground(Color.lightGray);
				iconoXcerrar.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
        
        
        //------------------------------------------------------
    }

    public static void main(String[] args)
    {
        VentanaMain VentanaBase = new VentanaMain();
        VentanaBase.setVisible(true);

        VentanaBase.setLocationRelativeTo(null);
    }
}
