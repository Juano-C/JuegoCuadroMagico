package recordPractica;

import java.util.TreeMap;

public class RecordMain
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        RecordPrueba.a�adirElementos(tmap, 1, "Data0");
        RecordPrueba.a�adirElementos(tmap, 2, "Data1");
        RecordPrueba.a�adirElementos(tmap, 3, "Data2");
        RecordPrueba.a�adirElementos(tmap, 4, "Data3");
        RecordPrueba.a�adirElementos(tmap, 5, "Data4");
        RecordPrueba.a�adirElementos(tmap, 6, "Data5");
        RecordPrueba.a�adirElementos(tmap, 7, "Data6");
        RecordPrueba.a�adirElementos(tmap, 8, "Data7");
        RecordPrueba.a�adirElementos(tmap, 9, "Data8");
        RecordPrueba.a�adirElementos(tmap, 10, "Data9");

        RecordPrueba.a�adirElementos(tmap, 11, "Data10");
        RecordPrueba.a�adirElementos(tmap, 1, "Data11");

        RecordPrueba.mostrarMap(tmap);
    }

}
