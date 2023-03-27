package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import disenio.GrillaGUI;
import juego.Juego;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import controladores.Controlador;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaComenzar extends JFrame
{
    private Timer tiempo;
    private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private JButton botonIniciar;
    private JButton botonPausar;
    private JLabel labelCronometro;
    private Juego juego;
    private GrillaGUI grillaVisual;
    
    private final static int WIDTH = 800, HEIGHT = 600;

    public VentanaComenzar()
    {
    	setUndecorated(true);
    	setType(Type.UTILITY);
    	getContentPane().setFocusable(false);
    	getContentPane().setBackground(new Color(0, 0, 51));
        setFont(null);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cuadro Mágico");
        setBounds(100, 100, WIDTH, HEIGHT);
        setResizable(false);
        tiempo = new Timer(10, acciones);
    }

    /* ---------------------- METODOS PRIVADAS  --------------------------------- */
    
    private void initComponents()
    {
        labelCronometro = new JLabel();
        labelCronometro.setForeground(new Color(255, 255, 255));
        
        botonIniciar = new JButton();
        botonIniciar.setFocusable(false);
        botonIniciar.setBorderPainted(false);
        botonIniciar.setForeground(new Color(255, 255, 255));
        botonIniciar.setBackground(new Color(0, 0, 51));
        botonIniciar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        botonPausar = new JButton();
        botonPausar.setFocusable(false);
        botonPausar.setForeground(new Color(255, 255, 255));
        botonPausar.setBackground(new Color(0, 0, 51));
        botonPausar.setBorderPainted(false);
        botonPausar.setFont(new Font("Tahoma", Font.PLAIN, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCronometro.setFont(new Font("Dialog", Font.BOLD, 22));
        labelCronometro.setText("00:00:00");

        //---------boton de Iniciar (inicia el cronometro desde cero)
        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        botonIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Controlador.crearJuego(4);
                grillaVisual = new GrillaGUI(5,5);
                grillaVisual.setBounds(10, 100, 750, 410);
                getContentPane().add(grillaVisual);
            }
        });
        
        //---------boton de Pausar (pausa el cronometro)
        botonPausar.setText("Pausar");
        botonPausar.setEnabled(false);
        botonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarActionPerformed(evt);
            }
        });

        JLabel labelTiempo = new JLabel("Tiempo:");
        labelTiempo.setForeground(new Color(255, 255, 255));
        labelTiempo.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //---------boton de salir (cierra juego)
        JButton botonSalir = new JButton("Salir");
        botonSalir.setBackground(new Color(255, 255, 255));
        botonSalir.setBorderPainted(false);
        botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        botonSalir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });

        //---------boton de Rendirse (vuelve a la ventanaMain)
        JButton botonRendirse = new JButton("Rendirse");
        botonRendirse.setFocusable(false);
        botonRendirse.setBorderPainted(false);
        botonRendirse.setBackground(new Color(0, 0, 51));
        botonRendirse.setForeground(new Color(255, 255, 255));
        botonRendirse.setFont(new Font("Tahoma", Font.PLAIN, 14));
        botonRendirse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                VentanaMain ventanaDificultad = new VentanaMain();
                ventanaDificultad.setVisible(true);
                
                ventanaDificultad.setLocationRelativeTo(null);
                dispose();
            }
        });
        
        /*
         * --------- Icono cerrar ventana ----------------
         */
        JLabel iconoXcerrar = new JLabel("X");
        iconoXcerrar.setForeground(new Color(255, 255, 255));
        iconoXcerrar.setFont(new Font("Verdana", Font.BOLD, 18));
        iconoXcerrar.setHorizontalAlignment(SwingConstants.CENTER);
        iconoXcerrar.setOpaque(true);
        iconoXcerrar.setBackground(new Color(0, 0, 51));
        
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
        
        
        

        //---------agregado en el layout de los botones
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(labelTiempo)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(labelCronometro, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(botonIniciar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(botonPausar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        							.addGap(6)
        							.addComponent(botonRendirse, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        						.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(iconoXcerrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(20)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(labelTiempo)
        						.addComponent(labelCronometro, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(botonRendirse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(botonPausar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        						.addComponent(botonIniciar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
        					.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        				.addComponent(iconoXcerrar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    private ActionListener acciones = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            centesimas_segundos ++;
            if(centesimas_segundos == 100)
            {
                segundos++;
                centesimas_segundos = 0;
            }
            if(segundos == 60)
            {
                minutos ++;
                segundos = 0;
            }
            actualizarEtiquetaTiempo();
        }
    };

    private void actualizarEtiquetaTiempo()
    {
        String texto =(minutos<=9?"0":"")+minutos+":"+(segundos <= 9?"0":"")+segundos+":"+(centesimas_segundos <=9?"0":"")+centesimas_segundos;
        labelCronometro.setText(texto);
    }
    
    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt)
    {
         tiempo.stop();
         botonIniciar.setEnabled(true);
    }
    
    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(tiempo.isRunning())
            tiempo.stop();

        centesimas_segundos = 0;
        segundos = 0;
        minutos = 0;

        actualizarEtiquetaTiempo();
        tiempo.start();

        botonIniciar.setText("Nuevo Juego");
        botonPausar.setEnabled(true);
        botonIniciar.setEnabled(false);
    }
    
    /* ------------------------------------------------------------------------ */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComenzar().setVisible(true);
            }
        });
    }
}
