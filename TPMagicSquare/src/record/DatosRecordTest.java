package record;

import static org.junit.Assert.assertFalse;
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
    @Test
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
        DatosRecord.eliminarElemento(tmap, 1);

        assertTrue(!tmap.containsKey(1));
    }

    //agregar elemento
    @Test
    public void agregarElementoTest()
    {
        DatosRecord.agregarElemento(tmap, 0, "Data1");
        assertTrue(tmap.containsKey(0));
    }

    //Voy a meter 10 valores y quiero que el ultimo se vaya 
    //es igual al test "quieroSegundoPuestoRecordLlenoTest. Ya que siempre elimina el ultimo puesto si llega un record que lo supere
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

        assertTrue(tmap.get(0).equals("Data10"));
    }

    //devolver el segundo puesto sin importar el orden de agregar
    @Test
    public void quieroSegundoPuestoRecordLlenoTest()
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
        DatosRecord.agregarElemento(tmap, 3, "Data10");

        assertTrue(DatosRecord.mostrarNombrePuesto(tmap, 1).equals("Data0"));
    }

    //Si existe el primer puesto
    @Test
    public void unRecordMaximoTest()
    {
        DatosRecord.agregarElemento(tmap, 100000, "ll");

        assertTrue(tmap.size()==1);
    }

    //si el map esta lleno, no agrega un 11avo elemento
    @Test
    public void recordLLenoTest()
    {
        DatosRecord.agregarElemento(tmap, 0, "juan");
        DatosRecord.agregarElemento(tmap, 1, "lau");
        DatosRecord.agregarElemento(tmap, 2, "pedro");
        DatosRecord.agregarElemento(tmap, 3, "maria");
        DatosRecord.agregarElemento(tmap, 4, "sol");
        DatosRecord.agregarElemento(tmap, 5, "lolo");
        DatosRecord.agregarElemento(tmap, 6, "messi");
        DatosRecord.agregarElemento(tmap, 7, "mario");
        DatosRecord.agregarElemento(tmap, 8, "luna");
        DatosRecord.agregarElemento(tmap, 9, "pollo");
        DatosRecord.agregarElemento(tmap, 10, "ultimo");

        assertTrue(tmap.size()==10);
    }

    //Deja el map en 10 slot. elimina los elementos de mas que se agreguen
    @Test
    public void eliminoElementoDeMasTest()
    {
        tmap.put(1, "Data0");
        tmap.put(2, "Data1");
        tmap.put(3, "Data2");
        tmap.put(4, "Data3");
        tmap.put(5, "Data4");
        tmap.put(6, "Data5");
        tmap.put(7, "Data6");
        tmap.put(8, "Data7");
        tmap.put(9, "Data8");
        tmap.put(10, "Data9");
        tmap.put(11, "Data10");

        DatosRecord.removerElementoDeMas(tmap);

        assertTrue(tmap.size()==10);
    }

}
