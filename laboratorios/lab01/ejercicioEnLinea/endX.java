//@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class endX
{
    public String endX(String str) {
     int i = 0;
     if(str.equals("")){
      return str;
     }
     if (str.charAt(i)=='x'){
      return endX(str.substring(i+1)) + 'x';
     } else {
      return str.charAt(i) + endX(str.substring(i+1));
     }

    }
}
