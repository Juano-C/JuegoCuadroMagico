package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaMain extends JFrame
{
   // private Juego juego;
    private JPanel contentPane;
    private JFrame frmCuadroMagico;
    private JButton reglas;

    //-------------------Launch the application.
    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    VentanaMain frame = new VentanaMain();
                    frame.setVisible(true);
                    
                    frame.setLocationRelativeTo(null);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    //-------------------Create the frame.
    public VentanaMain()
    {
    	setUndecorated(true); // Quita el marco a la ventana
        setTitle("Cuadro M\u00E1gico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //-------------------Boton comenzar
        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setFocusable(false);
        btnComenzar.setBorderPainted(false);
        btnComenzar.setForeground(new Color(255, 255, 255));
        btnComenzar.setBackground(new Color(0, 0, 51));
        btnComenzar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                VentanaComenzar VentanaCronometro = new VentanaComenzar();
                VentanaCronometro.setVisible(true);
                
                VentanaCronometro.setLocationRelativeTo(null);
                VentanaCronometro.setResizable(false);
                dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	VentanaComenzar VentanaCronometro = new VentanaComenzar();
                VentanaCronometro.setVisible(true);
                
                VentanaCronometro.setLocationRelativeTo(null);
                VentanaCronometro.setResizable(false);
                dispose();
            }
        });
        btnComenzar.setFont(new Font("Georgia", Font.PLAIN, 25));
        btnComenzar.setBounds(162, 61, 159, 46);
        contentPane.add(btnComenzar);

        //-------------------Boton dificultad
        JButton btnDificultad = new JButton("Dificultad");
        btnDificultad.setFocusable(false);
        btnDificultad.setForeground(new Color(255, 255, 255));
        btnDificultad.setBackground(new Color(0, 0, 51));
        btnDificultad.setBorderPainted(false);
        btnDificultad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                VentanaDificultad ventanaDificultad = new VentanaDificultad();
                ventanaDificultad.setVisible(true);
                
                ventanaDificultad.setLocationRelativeTo(null);
                ventanaDificultad.setResizable(false);
                dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	VentanaDificultad ventanaDificultad = new VentanaDificultad();
                ventanaDificultad.setVisible(true);
                
                ventanaDificultad.setLocationRelativeTo(null);
                ventanaDificultad.setResizable(false);
                dispose();
            }
        });
        btnDificultad.setFont(new Font("Georgia", Font.PLAIN, 25));
        btnDificultad.setBounds(162, 133, 159, 46);
        contentPane.add(btnDificultad);

        //-------------------autor/es
        JLabel lblAutors = new JLabel("Juan chauvet");
        lblAutors.setForeground(new Color(255, 255, 255));
        lblAutors.setBounds(10, 425, 141, 14);
        contentPane.add(lblAutors);

        //-------------------Boton Reglas
        JButton btnReglas = new JButton("Reglas");
        btnReglas.setFocusable(false);
        btnReglas.setBorderPainted(false);
        btnReglas.setBackground(new Color(0, 0, 51));
        btnReglas.setForeground(new Color(255, 255, 255));
        btnReglas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mentajeReglas) {
                JOptionPane.showMessageDialog(frmCuadroMagico, 
                        "OBJETIVO: El objetivo del juego consiste en igualar los n�meros presentados como RESULTADO \n" +
                        "tanto en las filas como en las columnas. Para ello se deben completar los casilleros con n�meros \n"+
                        "mayores a 0 (cero), los cuales se ir�n sumando por fila y por columna. Una vez completada una fila\n"+
                        "y/o  columna,  si  la  suma  equivale  al  respectivo  \"RESULTADO\"  entonces dicha  fila/columna  se \n"+
                        "considerar�   como  acertada  y se marcar� en color VERDE,  si se pasa  del valor se  marcar�   en \n"+
                        "color ROJO.\n"+
                        "El juego se gana cuando todas las filas y todas las columnas equivalen al resultado.\r\n" + 
                        "\r\n" + 
                        "INSERTAR N�MERO: Para insertar un n�mero en el tablero hay que hacer un click sobre el casillero \n"+
                        " a insertar, luego escribir el n�mero deseado y dar ENTER (*).\r\n" + 
                        "\r\n" + 
                        "(*) Una vez pulsado ENTER no se podr� modificar el valor del casillero.");
            }
        });
        btnReglas.setFont(new Font("Georgia", Font.PLAIN, 25));
        btnReglas.setBounds(162, 202, 159, 46);
        contentPane.add(btnReglas);

        //-------------------boton Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setBackground(new Color(0, 0, 51));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        btnSalir.setFont(new Font("Georgia", Font.PLAIN, 25));
        btnSalir.setBounds(162, 336, 159, 46);

        contentPane.add(btnSalir);
        
        

        //-------------------boton de musica 
        JButton btnMuteSoundMusic = new JButton("");
        btnMuteSoundMusic.setFocusable(false);
        btnMuteSoundMusic.setIcon(new ImageIcon("C:\\Users\\juan\\Desktop\\Universidad\\Materias\\No rendidas\\Programacion l l l\\tp 1er semestre 2023\\fotos cuadro magico\\fsfsfsf.png"));
        btnMuteSoundMusic.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                //AudioClip Sound;
                //Sound = java.applet.Applet.newAudioClip(getClass().getResource("/frontend/tetrisSound.wav"));
                //Sound.play();
            }
        });
        btnMuteSoundMusic.setBounds(456, 406, 34, 33);
        contentPane.add(btnMuteSoundMusic);
        
    
        
        /////////////////Creo boton records //////////7
        JButton btnNewButton = new JButton("Records");
        btnNewButton.setFocusable(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(new Color(0, 0, 51));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		VentanaRecord ventanaRecord = new VentanaRecord();
               ventanaRecord.main(null);

                dispose();
        	}
        	@Override
            public void mousePressed(MouseEvent e) {
        		VentanaRecord ventanaRecord = new VentanaRecord();
                ventanaRecord.main(null);

                 dispose();
        	}
        });
        btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 25));
        btnNewButton.setBounds(162, 261, 159, 52);
        contentPane.add(btnNewButton);
        
        
        
        JLabel iconoXcerrar = new JLabel("X");
        iconoXcerrar.setOpaque(true);
        iconoXcerrar.setHorizontalAlignment(SwingConstants.CENTER);
        iconoXcerrar.setForeground(Color.WHITE);
        iconoXcerrar.setFont(new Font("Verdana", Font.BOLD, 18));
        iconoXcerrar.setBackground(new Color(0, 0, 51));
        iconoXcerrar.setBounds(461, 0, 39, 34);
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
        
    }

}
