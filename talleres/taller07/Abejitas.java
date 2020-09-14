public class Abejitas
{
    public static boolean  iguales(LinkedListAbejitas lista1, LinkedListAbejitas lista2)
    {
        if(lista1.size() != lista2.size())
        {
            return false;
        }else {
            for (int i = 0; i < lista1.size(); i++) {
               if (lista1.get(i) != lista2.get(i)) return false;
            }
            return true;
        }
    }
    //busca el elemento de mayor tamaño
    public static int maximo(LinkedListAbejitas lista) {
        return maximoAux(lista.first);
    }
    
    private static int maximoAux(Node nodo) {
        if (nodo.next == null) 
        {
            return nodo.data;
        } else 
        {
            return Math.max(nodo.data, maximoAux(nodo.next));
        }

    }

    public static void main(String[] args) {

        LinkedListAbejitas list = new LinkedListAbejitas();
        LinkedListAbejitas list2 = new LinkedListAbejitas();
        
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        
        list2.insert(5, 0);
        list2.insert(4, 0);
        list2.insert(3, 0);
        list2.insert(2, 0);
        list2.insert(1, 0);
        
        System.out.println(iguales(list, list2));
        
        System.out.println(maximo(list));
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.contains(3));

        list.remove(4);

        System.out.println(list.contains(3));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
