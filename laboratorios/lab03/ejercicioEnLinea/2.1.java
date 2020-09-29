import java.util.*;
/**
 * Juan Pablo Henao y Diego Alejandro Vanegas
 */
public class BrokenKey
{
    public static void teclado(String a){
        LinkedList<String> texto  = new LinkedList<>();
        int n = a.length();
        boolean end = false;
        StringBuilder text = new StringBuilder("");
        for(int i = 0; i < n-1; i++){  
            char letra = a.charAt(i);
            if(letra == ']' || letra == '['){
                if(end == true){
                    texto.addLast(text.toString());
                } else {
                    texto.addFirst(text.toString());
                }
                if(letra == '['){
                    end = false;
                } else {
                    end = true;
                }
                text = new StringBuilder("");
            }
            else {
                text.append(letra);
            }
        }
        if(end == true){
            texto.addLast(text.toString());
        } else {
            texto.addFirst(text.toString());
        }
        while(texto.size() > 0){
            System.out.print(texto.pollFirst());
        }
        System.out.println();
    }
}
