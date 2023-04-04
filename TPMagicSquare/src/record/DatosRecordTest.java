package record;

import static org.junit.Assert.assertTrue;
import java.util.TreeMap;
import org.junit.Test;

public class DatosRecordTest
{
    private TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

    //si se agrega una key que se excede de tiempo
    @Test (expected = IllegalArgumentException.class)
    public void superaTiempoTest()
    {
        DatosRecord.agregarElemento(tmap, 1999999, "Data0");
    }

    //nombre vacio (invalido)
    @Test (expected = IllegalArgumentException.class)
    public void nombreInvalidoTest()
    {
    	DatosRecord.agregarElemento(tmap, 0, "");
    }

    //elimina elemento
    @Test (expected = IllegalArgumentException.class)
    public void eliminarElementoTest()
    {
    	DatosRecord.agregarElemento(tmap, 0, "Data1");
    	DatosRecord.agregarElemento(tmap, 1, "Data2");
    	DatosRecord.agregarElemento(tmap, 2, "Data3");
    	DatosRecord.agregarElemento(tmap, 3, "Data4");
    	DatosRecord.agregarElemento(tmap, 4, "Data5");
    	DatosRecord.agregarElemento(tmap, 5, "Data6");
    	DatosRecord.agregarElemento(tmap, 6, "Data7");
    	DatosRecord.agregarElemento(tmap, 7, "Data8");
    	DatosRecord.agregarElemento(tmap, 8, "Data9");
    	DatosRecord.agregarElemento(tmap, 9, "Data10");
    	
    	DatosRecord.agregarElemento(tmap, 10, "Data11");
    	
    	assertTrue(tmap.size()==10);
    }

    //agregar elemento
    @Test
    public void agregarElementoTest()
    {
    	DatosRecord.agregarElemento(tmap, 0, "Data1");
    	assertTrue(tmap.size()==1);
    }

}
