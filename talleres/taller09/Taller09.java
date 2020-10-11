import java.util.HashMap;

public class Taller9{
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }

public static boolean buscar(HashMap empresas,String key){
       return empresas.containsKey(key);
    }

public static boolean contieneValue(HashMap empresas,String value){
        return empresas.containsValue(value);
    } 
}
