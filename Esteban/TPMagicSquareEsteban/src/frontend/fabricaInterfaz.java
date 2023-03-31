package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controladores.Controlador;
import disenio.DisenioBoton;
import disenio.IconoCerrarVentana;

public class fabricaInterfaz extends JFrame {

	public static JButton crearBoton(String texto, int x, int y, int ancho, int alto) {

		JButton boton = new JButton(texto);

		boton.setFocusable(false);
		boton.setBorderPainted(false);
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(0, 0, 51));
		boton.setFont(new Font("Georgia", Font.PLAIN, 25));
		boton.setBounds(x, y, ancho, alto);
		return boton;
	}

	public static IconoCerrarVentana crearBotonCerrar(int x, int y, int ancho, int alto) {
		IconoCerrarVentana boton = new IconoCerrarVentana();
		boton.setBounds(x, y, ancho, alto);
		return boton;
	}
	
	public static JButton crearBotonMusica(int x,int y,int ancho,int alto) {
		 
		JButton boton=new JButton(new ImageIcon("JuegoCuadroMagico\Esteban\icons8-music-30"));
		boton.setBounds(x, y, ancho, alto);
		boton.setFocusable(false);
		return boton;
	     
	}


}
