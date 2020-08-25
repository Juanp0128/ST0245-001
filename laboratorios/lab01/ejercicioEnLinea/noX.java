@Author Juan Pablo Henao, Diego Alejandro Vanegas
public class noX
{
    public String noX(String str) {
    int i = 0;
    if(str.equals("")){
    return str;
    }
    if (str.charAt(i)=='x'){
      return noX(str.substring(i+1));
    } else {
      return str.charAt(i) + noX(str.substring(i+1));
    }
  
    }
}
