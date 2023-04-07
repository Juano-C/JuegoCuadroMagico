package sonido;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audios
{
    private static String _dir = System.getProperty("user.dir");
    private static String _rutaMusica = _dir + "//src//sonido//musicGameTP.wav";
    private static Clip _musica;

    public static void musicaPlay()
    {
        try
        {
            if(_musica == null || !_musica.isActive())
            {
                File archivoMusica = new File(_rutaMusica);
                AudioInputStream stream = AudioSystem.getAudioInputStream(archivoMusica.getAbsoluteFile());
                _musica = AudioSystem.getClip();
                _musica.open(stream);
                _musica.loop(Clip.LOOP_CONTINUOUSLY);
                _musica.start();
            }
        }
        catch(Exception e){}
    }

    public static void musicaStop()
    {
        if(_musica != null && _musica.isActive())
            _musica.stop();
    }

}
