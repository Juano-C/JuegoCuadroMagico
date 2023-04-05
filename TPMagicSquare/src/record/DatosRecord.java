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
    public static void agregarElemento(TreeMap<Integer, String> recordMap, int tiempo, String nombre)
    {
        //parametros invalidos = excepcion
        invalidParameters(tiempo, nombre);

        //agrega tiempo y nombre al map de records 
        recordMap.put(tiempo, nombre);

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
    
     static String mostrarPuesto(TreeMap<Integer, String> recordMap,int puesto)
    {
        Set<Map.Entry<Integer, String> > entrySet = recordMap.entrySet();
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
        
        
        String salida = null;
        
        for (int indiceMap = 0; indiceMap < recordMap.size(); indiceMap++)
        {
        	
        	if(puesto==indiceMap) {
        		salida=  entryArray[indiceMap].getValue();
        	}
            
        }
        return salida;
        
    }
    public static void mostrarKeys(TreeMap<Integer, String> recordMap) {
    	for(Integer key:recordMap.keySet()) {
    		System.out.println(key);
    		System.out.println(recordMap.get(key));
    	}
    }



public static void main(String[] args){
	TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

    DatosRecord.agregarElemento(tmap, 1000, "Data0");
    DatosRecord.agregarElemento(tmap, 222, "Data1");
    DatosRecord.agregarElemento(tmap, 30000, "Data2");
    DatosRecord.agregarElemento(tmap, 41, "Data3");
    DatosRecord.agregarElemento(tmap, 54, "Data4");
    DatosRecord.agregarElemento(tmap, 6, "Data5");
    DatosRecord.agregarElemento(tmap, 17, "Data6");
    DatosRecord.agregarElemento(tmap, 86, "Data7");
    DatosRecord.agregarElemento(tmap, 2, "Data8");
    DatosRecord.agregarElemento(tmap, 10, "Data9");
  
    DatosRecord.mostrarKeys(tmap);
}
}
