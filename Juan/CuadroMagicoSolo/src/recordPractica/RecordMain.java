package recordPractica;

import java.util.TreeMap;

public class RecordMain
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        RecordPrueba.aņadirElementos(tmap, 1, "Data0");
        RecordPrueba.aņadirElementos(tmap, 2, "Data1");
        RecordPrueba.aņadirElementos(tmap, 3, "Data2");
        RecordPrueba.aņadirElementos(tmap, 4, "Data3");
        RecordPrueba.aņadirElementos(tmap, 5, "Data4");
        RecordPrueba.aņadirElementos(tmap, 6, "Data5");
        RecordPrueba.aņadirElementos(tmap, 7, "Data6");
        RecordPrueba.aņadirElementos(tmap, 8, "Data7");
        RecordPrueba.aņadirElementos(tmap, 9, "Data8");
        RecordPrueba.aņadirElementos(tmap, 10, "Data9");

        RecordPrueba.aņadirElementos(tmap, 11, "Data10");
        RecordPrueba.aņadirElementos(tmap, 1, "Data11");

        RecordPrueba.mostrarMap(tmap);
    }

}
