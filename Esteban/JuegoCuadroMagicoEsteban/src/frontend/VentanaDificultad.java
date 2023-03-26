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

public class VentanaDificultad extends JFrame {

    public VentanaDificultad() {
        // Tama�os
        super();
        setTitle("Cuadro Magico");
        setVisible(true);
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);

        //-------------------ContentePane
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //-------------------Boton de facil
        JButton btnFacil = new JButton("Facil");
        btnFacil.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnFacil.setBounds(66, 100, 114, 34);
        contentPane.add(btnFacil);

        //-------------------Boton de medio
        JButton btnMedio = new JButton("Medio");
        btnMedio.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnMedio.setBounds(66, 188, 114, 34);
        contentPane.add(btnMedio);

        //-------------------Boton de dificil
        JButton btnDificil = new JButton("Dificil");
        btnDificil.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        btnDificil.setBounds(66, 276, 114, 34);
        contentPane.add(btnDificil);

        //-------------------Boton salir pantalla de dificultad
        JButton btnSalir = new JButton("Salir");
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
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        lblNewLabel.setBounds(237, 100, 271, 27);
        contentPane.add(lblNewLabel);

        JLabel lblGrillaDex = new JLabel("Grilla de 4x4 con valores de 0 a 20");
        lblGrillaDex.setFont(new Font("Serif", Font.PLAIN, 20));
        lblGrillaDex.setBounds(237, 188, 281, 27);
        contentPane.add(lblGrillaDex);
        
        JLabel lblGrillaDex_1 = new JLabel("Grilla de 5x5 con valores de 0 a 50");
        lblGrillaDex_1.setFont(new Font("Serif", Font.PLAIN, 20));
        lblGrillaDex_1.setBounds(237, 276, 281, 27);
        contentPane.add(lblGrillaDex_1);
        //------------------------------------------------------
    }

    public static void main(String[] args)
    {
        VentanaMain VentanaBase = new VentanaMain();
        VentanaBase.setVisible(true);

        VentanaBase.setLocationRelativeTo(null);
    }
}
