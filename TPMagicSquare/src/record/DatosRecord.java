package record;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


//Creo que hay que poner metodos en privado
public class DatosRecord
{
	private static int tamanioMap=18; //cantidad de records que vamos a guardar
	
    //Si la key (tiempo) se ha excedido     |  Excepcion
    //Si no pone ningun nombre              |
    public static void agregarElemento(TreeMap<Integer, String> recordMap, int tiempo, String nombre)
    {
        //parametros invalidos = excepcion
        invalidParameters(tiempo, nombre);

        //agrega tiempo y nombre al map de records
        recordMap.put(tiempo, nombre);

        //quita ultimo elemento asi solo almacena 10 records
        removerElementoDeMas(recordMap);
    }

    //si el map esta lleno, elimina la ultima posicion si el tiempo pasado por parametro es menor a el ultimo elemento del map
    public void eliminarUltimoSiMapLleno(TreeMap<Integer, String> recordMap, int tiempo)
    {
        if(recordMap.size()>=tamanioMap)
        {
              Set<Map.Entry<Integer, String>> entrySet = recordMap.entrySet();
              Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

              if(tiempo < entryArray[recordMap.size()-1].getKey())
            	  DatosRecord.eliminarElemento(recordMap, recordMap.size()-1);
        }
    }

    //Eliminar elementos > 18
    public static void removerElementoDeMas(TreeMap<Integer, String> recordMap)
    {
        if(recordMap.size()>tamanioMap)
        	DatosRecord.eliminarElemento(recordMap, recordMap.size()-1);
    }

    //Quita ultimo elemento asi solo almacena 10 records
    //Se podria usar una variable que almacene el tiempo maximo ( 999999 ) para comparar con la key
    public static void invalidParameters(int key, String value)
    {
        if(key>= 999999 || value.isEmpty())
            throw new IllegalArgumentException("parametros invalidos");
    }

    //muestra el puntaje que tiene un elemento pasado por parametro como puesto
    public int mostrarPuntajePuesto(TreeMap<Integer, String> recordMap, int puesto)
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
    
  //muestra el nombre que tiene un elemento pasado por parametro como puesto
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

    //elimina elemento del map en la posicion pasada por parametro
    public static void eliminarElemento(TreeMap<Integer, String> recordMap, int posicion)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

        for (int posicionMap = 0; posicionMap < recordMap.size(); posicionMap++)
        {
            if( posicion == posicionMap )
                recordMap.remove(entryArray[posicionMap].getKey(), entryArray[posicionMap].getValue());

        }
    }

}
