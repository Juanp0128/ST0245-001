public class Taller2{

       public static int gcd(int p, int q){
            if(q==0){
               return p;
              }
            else {
               gcd(q, p%q);
              }
            
       }

}
