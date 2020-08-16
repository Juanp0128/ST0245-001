import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/**
 * Esta clase lee un archivo de datos CSV
 * 
 * @Juan Pablo Henao & Diego Vanegas
 * @1.0
 */
public class LeerCSV
{

   
   public static final String PuntoYComa=";";
   public static final String QUOTE="\"";
   
   public static void main(String[] args) {
      
      BufferedReader br = null;
      
      try {
         
         br =new BufferedReader(new FileReader(//Ruta del archivo));
         String line = br.readLine();
         while (null!=line) {
            String [] campos = line.split(PuntoYComa);
            campos = removeTrailingQuotes(campos);
            //Si queremos mostrar los archivos leídos agregar: System.out.println(Arrays.toString(campos));           
            line = br.readLine();
         }
         
      } catch (Exception e) {
         System.err.println("Error! "+e.getMessage());
      } finally {
         if (null!=br){
            try {
               br.close();
            } catch (IOException e) {
               System.err.println("Error closing file !! "+e.getMessage());
            }
         }
      }
      
   }
   
   private static String[] removeTrailingQuotes(String[] campos) {
      String result[] = new String[campos.length];
      for (int i=0;i<result.length;i++){
         result[i] = campos[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
}
