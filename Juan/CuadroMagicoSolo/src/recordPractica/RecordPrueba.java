package recordPractica;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RecordPrueba
{
    //si la key (tiempo) se ha excedido     |  Excepcion
    //si no pone ningun nombre              |
    public static void añadirElementos(TreeMap<Integer, String> tmap, int key, String value)
    {
        //parametros invalidos = excepcion
        invalidParameters(key, value);

        //agrega tiempo y nombre a los records
        tmap.put(key, value);

        //quita ultimo elemento asi solo almacena 10 records
        removerUltimo(tmap);
    }

    //parametros invalidos = excepcion
    public static void removerUltimo(TreeMap<Integer, String> tmap)
    {
        if(tmap.size()>10)
            tmap.pollLastEntry();
    }

    //quita ultimo elemento asi solo almacena 10 records
    public static void invalidParameters(int key, String value)
    {
        if(key>=999999 || value.isEmpty())
            throw new IllegalArgumentException("parametros invalidos");
    }

    //mostrar el Map (no es necesario implementar, se puede borrar)
    public static void mostrarMap(TreeMap<Integer, String> tmap)
    {
        Set<Map.Entry<Integer, String> > entrySet = tmap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int indiceMap = 0; indiceMap < tmap.size(); indiceMap++)
        {
            System.out.println("Puntaje " + indiceMap + ": "+ entryArray[indiceMap].getKey());
            System.out.println("Nombre " + indiceMap + ": "+ entryArray[indiceMap].getValue());
            System.out.println();
        }
    }

}
