package record;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
 * Creo que hay que poner metodos en privado
 */
public class DatosRecord
{

    //Si la key (tiempo) se ha excedido     |  Excepcion
    //Si no pone ningun nombre              |
    public static void agregarElemento(TreeMap<Integer, String> recordMap, int key, String value)
    {
        //parametros invalidos = excepcion
        invalidParameters(key, value);

        //agrega tiempo y nombre al map de records 
        recordMap.put(key, value);

        //quita ultimo elemento asi solo almacena 10 records
        removerUltimo(recordMap);
    }

    //Parametros invalidos = excepcion
    public static void removerUltimo(TreeMap<Integer, String> recordMap)
    {
        if(recordMap.size()>10)
        	recordMap.pollLastEntry();
    }

    //Quita ultimo elemento asi solo almacena 10 records
    //Se podria usar una variable que almacene el tiempo maximo ( 999999 ) para comparar con la key
    public static void invalidParameters(int key, String value)
    {
        if(key>= 999999 || value.isEmpty())
            throw new IllegalArgumentException("parametros invalidos");
    }

    //mostrar el Map (no es necesario implementar, se puede borrar)
    public static void mostrarMap(TreeMap<Integer, String> recordMap)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int indiceMap = 0; indiceMap < recordMap.size(); indiceMap++)
        {
            System.out.println("Puntaje " + indiceMap + ": "+ entryArray[indiceMap].getKey());
            System.out.println("Nombre " + indiceMap + ": "+ entryArray[indiceMap].getValue());
            System.out.println();
        }
    }

}
