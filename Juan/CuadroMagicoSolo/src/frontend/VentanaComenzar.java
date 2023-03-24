package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VentanaComenzar extends javax.swing.JFrame
{
    private Timer tiempo;
    private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonPausar;
    private javax.swing.JLabel etiqueta_tiempo;

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
        etiqueta_tiempo.setText(texto);
    }

    public VentanaComenzar()
    {
        setFont(null);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cuadro Mágico");
        setBounds(100, 100, 470, 494);
        tiempo = new Timer(10, acciones);
    }

    private void initComponents()
    {
        etiqueta_tiempo = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        botonIniciar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        botonPausar = new javax.swing.JButton();
        botonPausar.setFont(new Font("Tahoma", Font.PLAIN, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiqueta_tiempo.setFont(new Font("Dialog", Font.BOLD, 22));
        etiqueta_tiempo.setText("00:00:00");

        //---------boton de Iniciar (inicia el cronometro desde cero)
        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonIniciarActionPerformed(evt);
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

        JLabel lblNewLabel = new JLabel("Tiempo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //---------boton de salir (cierra juego)
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });

        //---------boton de Rendirse (vuelve a la ventanaMain)
        JButton btnRendirse = new JButton("Rendirse");
        btnRendirse.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRendirse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                VentanaMain ventanaDificultad = new VentanaMain();
                ventanaDificultad.setVisible(true);
                
                ventanaDificultad.setLocationRelativeTo(null);
                dispose();
            }
        });

        //---------agregado en el layout de los botones
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnSalir)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNewLabel)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(etiqueta_tiempo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonIniciar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(botonPausar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addGap(6)
                            .addComponent(btnRendirse, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(etiqueta_tiempo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(btnRendirse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonPausar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(botonIniciar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                    .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
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

    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt)
    {
         tiempo.stop();
         botonIniciar.setEnabled(true);
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComenzar().setVisible(true);
            }
        });
    }
}
