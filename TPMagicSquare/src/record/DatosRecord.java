package record;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//Creo que hay que poner metodos en privado
public class DatosRecord
{
    //Si la key (tiempo) se ha excedido     |  Excepcion
    //Si no pone ningun nombre              |
    public static void agregarElemento(TreeMap<Integer, String> recordMap, int tiempo, String nombre)
    {
        //parametros invalidos = excepcion
        invalidParameters(tiempo, nombre);

        eliminarUltimoSiMapLleno(recordMap, tiempo);

        //agrega tiempo y nombre al map de records
        recordMap.put(tiempo, nombre);

        //quita ultimo elemento asi solo almacena 10 records
        removerElementoDeMas(recordMap);
    }

    public static void eliminarUltimoSiMapLleno(TreeMap<Integer, String> recordMap, int tiempo)
    {
        if(recordMap.size()>=10)
        {
              Set<Map.Entry<Integer, String>> entrySet = recordMap.entrySet();
              Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

              if(tiempo < entryArray[recordMap.size()-1].getKey())
                  DatosRecord.eliminarElemento(recordMap, recordMap.size()-1);
        }
    }

    //Eliminar elementos > 10
    public static void removerElementoDeMas(TreeMap<Integer, String> recordMap)
    {
        if(recordMap.size()>10)
            DatosRecord.eliminarElemento(recordMap, recordMap.size()-1);
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
        Set<Map.Entry<Integer, String>> entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int indiceMap = 0; indiceMap < recordMap.size(); indiceMap++)
        {
            System.out.println("puesto: "+indiceMap);

            System.out.println("Puntaje: "+ entryArray[indiceMap].getKey());
            System.out.println("Nombre: "+ entryArray[indiceMap].getValue());
            System.out.println();
        }
    }

    public static int mostrarPuntajePuesto(TreeMap<Integer, String> recordMap, int puesto)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int indiceMap = 0; indiceMap < recordMap.size(); indiceMap++)
        {
            if(puesto==indiceMap)
                return entryArray[indiceMap].getKey();
        }
        throw new IllegalArgumentException("parametros invalidos");
    }

    public static String mostrarNombrePuesto(TreeMap<Integer, String> recordMap, int puesto)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int indiceMap = 0; indiceMap < recordMap.size(); indiceMap++)
        {
            if(puesto==indiceMap)
                return entryArray[indiceMap].getValue();
        }
        throw new IllegalArgumentException("parametros invalidos");
    }

    public static void eliminarElemento(TreeMap<Integer, String> recordMap, int posicion)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int posicionMap = 0; posicionMap < recordMap.size(); posicionMap++)
        {
            if( posicion == posicionMap )
            {
                recordMap.remove(entryArray[posicionMap].getKey(), entryArray[posicionMap].getValue());
            }
        }
    }

}
