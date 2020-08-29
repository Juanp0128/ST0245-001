public class Tiempop
{
    public static int suma(int[] n){
        int cont = 0; // c1
        for(int i = 0; i < n.length; i++){ // c2 + c3n
            cont++; //c4*n
        }
        return cont; //c5
    }                // T(n) = c1 + c2 + c3n + c4n + c5 es 0(n)
    
    public static void main(String[] args){
        for(int n = 1; n<=20; n++){
            long ti = System.currentTimeMillis();
            suma(new int[n]);
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        }
    }
}
