//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class AllStar
{
    public String allStar(String str) {
    int i = 0;
      if(str.equals("") || str.length()==1){
      return str;
    
     }  
    return str.charAt(i)+"*"+ allStar(str.substring(i+1));
   }
}
