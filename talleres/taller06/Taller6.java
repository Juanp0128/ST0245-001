public class Taller6
{
    /**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime.
     * el arreglo tiene que estar de forma inversa
     * ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
     * @return un arraylist con todos los elementos ingresados de forma invertida
     */
    public static ArrayList<Integer> opcional2(){
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n != -1){
            arr.add(n);
            n = scan.nextInt();
        }
        
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i< arr.size(); i++){
            arr2.add(arr.get(arr.size()-1-i));
        }
        return arr2;
    }
}
