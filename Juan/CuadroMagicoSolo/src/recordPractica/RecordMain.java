package recordPractica;

import java.util.TreeMap;

public class RecordMain
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        RecordPrueba.agregarElemento(tmap, 1, "Data0");
        RecordPrueba.agregarElemento(tmap, 2, "Data1");
        RecordPrueba.agregarElemento(tmap, 3, "Data2");
        RecordPrueba.agregarElemento(tmap, 4, "Data3");
        RecordPrueba.agregarElemento(tmap, 5, "Data4");
        RecordPrueba.agregarElemento(tmap, 6, "Data5");
        RecordPrueba.agregarElemento(tmap, 7, "Data6");
        RecordPrueba.agregarElemento(tmap, 8, "Data7");
        RecordPrueba.agregarElemento(tmap, 9, "Data8");
        RecordPrueba.agregarElemento(tmap, 10, "Data9");

        RecordPrueba.agregarElemento(tmap, 11, "Data10");
        RecordPrueba.agregarElemento(tmap,  1, "Data11");

        /*
         * RecordPrueba.agregarElemento(tmap, 1, "Data0");
         * RecordPrueba.agregarElemento(tmap, 2, "Data11");
         * RecordPrueba.agregarElemento(tmap, 3, "Data2");
         * RecordPrueba.agregarElemento(tmap, 4, "Data3");
         * RecordPrueba.agregarElemento(tmap, 5, "Data4");
         * RecordPrueba.agregarElemento(tmap, 6, "Data5");
         * RecordPrueba.agregarElemento(tmap, 7, "Data6");
         * RecordPrueba.agregarElemento(tmap, 8, "Data7");
         * RecordPrueba.agregarElemento(tmap, 9, "Data8");
         * RecordPrueba.agregarElemento(tmap, 10, "Data9");
         * 
         * RecordPrueba.agregarElemento(tmap, 1, "Data0");
         * RecordPrueba.agregarElemento(tmap, 2, "Data11");
         * RecordPrueba.agregarElemento(tmap,  3, "Data1");
         * 
         */
        
        RecordPrueba.mostrarMap(tmap);
    }

}
