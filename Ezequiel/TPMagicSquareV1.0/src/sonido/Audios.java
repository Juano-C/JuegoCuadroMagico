package sonido;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audios {

	private static String _dir = System.getProperty("user.dir");
	private static String _rutaMusica = _dir + "//src//sonido//musicGameTP.wav";
	private static String _rutaSonidoClick = _dir + "//src//sonido//sonidoClick.wav";
	private static Clip _musica;
	private static Clip _sonidoClick;
	
	public static void musicaPlay()  {
		try {
		if(_musica == null || !_musica.isActive()) {
			File archivoMusica = new File(_rutaMusica);
			AudioInputStream stream = AudioSystem.getAudioInputStream(archivoMusica.getAbsoluteFile());
			_musica = AudioSystem.getClip();
			_musica.open(stream);
			_musica.loop(Clip.LOOP_CONTINUOUSLY);
			_musica.start();
		}
		}catch(Exception e){
			
		}
	}
	
	public static void musicaStop() {
		if(_musica != null && _musica.isActive()) {
			_musica.stop();
		}
	}
	
	public static void sonidoClick() {
		try {
			// Creo el archivo
			File archivo = new File(_rutaSonidoClick);
			// Creo el Stream de Audio
			AudioInputStream stream = AudioSystem.getAudioInputStream(archivo.getAbsoluteFile());
			// Le asigno un clip a mi variable Clip
			_sonidoClick = AudioSystem.getClip();
			// Abro el audio que esta en la en mi stream 
			_sonidoClick.open(stream);
			
			// Volumen del clip
			float volume = (float) 0.2; 
			FloatControl gainControl = (FloatControl) _sonidoClick.getControl(FloatControl.Type.MASTER_GAIN);        
			gainControl.setValue(20f * (float) Math.log10(volume));
		
			// Reproduzco el audio
			_sonidoClick.start();
		} catch (Exception e) {
		}
	}
	
}
