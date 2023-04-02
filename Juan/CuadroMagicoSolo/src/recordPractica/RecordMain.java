package recordPractica;

import java.util.TreeMap;

public class RecordMain
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        RecordPrueba.añadirElementos(tmap, 1, "Data0");
        RecordPrueba.añadirElementos(tmap, 2, "Data1");
        RecordPrueba.añadirElementos(tmap, 3, "Data2");
        RecordPrueba.añadirElementos(tmap, 4, "Data3");
        RecordPrueba.añadirElementos(tmap, 5, "Data4");
        RecordPrueba.añadirElementos(tmap, 6, "Data5");
        RecordPrueba.añadirElementos(tmap, 7, "Data6");
        RecordPrueba.añadirElementos(tmap, 8, "Data7");
        RecordPrueba.añadirElementos(tmap, 9, "Data8");
        RecordPrueba.añadirElementos(tmap, 10, "Data9");

        RecordPrueba.añadirElementos(tmap, 11, "Data10");
        RecordPrueba.añadirElementos(tmap, 1, "Data11");

        RecordPrueba.mostrarMap(tmap);
    }

}
