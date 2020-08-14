public class Permutation {
    public static void permutation(String str) {
        permutationAux("", str);

    }

    private static void permutationAux(String respuesta, String pregunta) {
        if (pregunta.length() == 0) {
            System.out.println(respuesta);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(respuesta));
        } else {
            for (int i = 0; i <= pregunta.length() - 1; i++) {
                String C1 = respuesta + String.valueOf(pregunta.charAt(i));
                String C2 = pregunta.replace(String.valueOf(pregunta.charAt(i)), "");
                permutationAux(C1, C2);
            }
        }
    }
}
