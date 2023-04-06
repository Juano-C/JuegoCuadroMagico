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
    
    /*
     * Voy a meter 10 valores y quiero que el ultimo se vaya 
     * Warining!! los parametros tienen que ser enteros
     */
    @Test
    public void agregoElementoRecordMaximoTest()
    {
    	DatosRecord.agregarElemento(tmap, 7, "Data0");
    	DatosRecord.agregarElemento(tmap, 8, "Data1");
    	DatosRecord.agregarElemento(tmap, 9, "Data2");
    	DatosRecord.agregarElemento(tmap, 14, "Data3");
    	DatosRecord.agregarElemento(tmap, 18, "Data4");
    	DatosRecord.agregarElemento(tmap, 27, "Data5");
    	DatosRecord.agregarElemento(tmap, 33, "Data6");
    	DatosRecord.agregarElemento(tmap, 47, "Data7");
    	DatosRecord.agregarElemento(tmap, 50, "Data8");
    	DatosRecord.agregarElemento(tmap, 200, "Data9");
    	
    	DatosRecord.agregarElemento(tmap, 0, "Data10");
    	
    	assertTrue(tmap.get(0).equals("Data1"));
    	
    }
    @Test
    public void quieroSegundoPuestoRecordLlenoTest() {
    	DatosRecord.agregarElemento(tmap, 7, "Data0");
    	DatosRecord.agregarElemento(tmap, 8, "Data1");
    	DatosRecord.agregarElemento(tmap, 9, "Data2");
    	DatosRecord.agregarElemento(tmap, 14, "Data3");
    	DatosRecord.agregarElemento(tmap, 18, "Data4");
    	DatosRecord.agregarElemento(tmap, 27, "Data5");
    	DatosRecord.agregarElemento(tmap, 33, "Data6");
    	DatosRecord.agregarElemento(tmap, 47, "Data7");
    	DatosRecord.agregarElemento(tmap, 50, "Data8");
    	DatosRecord.agregarElemento(tmap, 200, "Data9");
    	
    	DatosRecord.agregarElemento(tmap, 3, "Data10");
    	assertTrue(tmap.get(1).equals("Data0"));
    }
    
    @Test 
    public void unRecordMaximoTest() {
    	DatosRecord.agregarElemento(tmap, 100000, "ll");
    	assertTrue(DatosRecord.mostrarPuesto(tmap, 0).equals("ll"));
    }
    @Test 
    public void tresRecordsTest() {
    	DatosRecord.agregarElemento(tmap, 10000, "juan");
    	DatosRecord.agregarElemento(tmap, 11, "lau");
    	DatosRecord.agregarElemento(tmap, 3, "pedro");
    	
    	assertTrue(tmap.get(2).equals("lau"));
    }
    @Test 
    public void recordLLenoTest() {
    	DatosRecord.agregarElemento(tmap, 10000, "juan");
    	DatosRecord.agregarElemento(tmap, 11, "lau");
    	DatosRecord.agregarElemento(tmap, 3, "pedro");
    	DatosRecord.agregarElemento(tmap, 578, "maria");
    	DatosRecord.agregarElemento(tmap, 22, "sol");
    	DatosRecord.agregarElemento(tmap, 18000, "lolo");
    	DatosRecord.agregarElemento(tmap, 43, "messi");
    	DatosRecord.agregarElemento(tmap, 39, "mario");
    	DatosRecord.agregarElemento(tmap, 56, "luna");
    	DatosRecord.agregarElemento(tmap, 12, "pollo");
    	
    	
    	assertTrue(tmap.get(10).equals("lolo"));
    }
    @Test 
    public void eliminoUltimoPuestoTest() {
    	DatosRecord.agregarElemento(tmap, 10000, "juan");
    	DatosRecord.agregarElemento(tmap, 11, "lau");
    	DatosRecord.agregarElemento(tmap, 3, "pedro");
    	DatosRecord.agregarElemento(tmap, 578, "maria");
    	DatosRecord.agregarElemento(tmap, 22, "sol");
    	DatosRecord.agregarElemento(tmap, 18000, "lolo");
    	DatosRecord.agregarElemento(tmap, 43, "messi");
    	DatosRecord.agregarElemento(tmap, 39, "mario");
    	DatosRecord.agregarElemento(tmap, 56, "luna");
    	DatosRecord.agregarElemento(tmap, 12, "pollo");
    	
    	DatosRecord.agregarElemento(tmap, 11000, "saco_a_lolo");
    	
    	
    	assertTrue(tmap.get(10).equals("saco_a_lolo"));
    }
    

}
