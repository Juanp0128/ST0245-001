package Proyectoo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {
    public static final String PuntoYComa = ";";
    public static final String QUOTE = "\"";
    public static String Doc = "lite.csv";
    static String[][] matriz;

    public LeerCSV(String[][] matriz) {
        LeerCSV.matriz = matriz;
    }

    public static String[][] cargarCSV() throws IOException {

        BufferedReader br = null;
        List<String[]> cargar = new ArrayList<String[]>();

        try {

            br = new BufferedReader(new FileReader(Doc));
            String line = br.readLine();
            while (null != line) {
                String[] campos = line.split(PuntoYComa);
                campos = removeTrailingQuotes(campos);
                line = br.readLine();
                cargar.add(campos);
            }
            br.close();

        } catch (Exception e) {
            System.err.println("Error! " + e.getMessage());
        }
        matriz = new String[cargar.size()][];
        for (int i = 0; i < cargar.size(); i++) {
            String[] car = cargar.get(i);
            matriz[i] = car;
        }
        return matriz;

    }


    private static String[] removeTrailingQuotes(String[] campos) {
        String result[] = new String[campos.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = campos[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
}
