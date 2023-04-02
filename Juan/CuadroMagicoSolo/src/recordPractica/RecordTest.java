package recordPractica;

import java.util.TreeMap;
import org.junit.Test;

public class RecordTest
{
    TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

    //si el map supera 10 posiciones
    @Test
    public void superaLargo(){}

    //si hay key se excede
    @Test 
    public void superaTiempo()
    {
        RecordPrueba.añadirElementos(tmap, 1, "Data0");
    }

    //nombre vacio (invalido)
    @Test
    public void nombreInvalido(){}

    //elimina elemento
    @Test
    public void eliminarElemento(){}

    //agregar elemento
    @Test
    public void agregarElemento(){}

}
