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
    
    /**
     * @param n el numero hasta el cual se llevara acabo el patrón siguiente
     * vamos a implementar un nuevo nuevo a la vez no antes de haber
     * contado desde el inicio ejemplo n=4 entonces el arreglo sería
     * [ 1,1,2,1,2,3,1,2,3,4] de modo que siempre que se ingresa uno nuevo
     * comienza la cuenta desde 1.
     * @return un arraylist con todos los elementos ingresados
     */
    public static ArrayList<Integer> opcional3(int n){
        ArrayList<Integer> arra = new ArrayList<>();
        for(int i = 1; i <= n; i++){
	    for(int j = 1; j <= i; j++){
		arra.add(j);          
	    }
	}
	return arra;
    }
}
