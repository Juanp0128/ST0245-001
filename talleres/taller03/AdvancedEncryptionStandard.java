import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


public class AdvancedEncryptionStandard {
    public static byte[] decrypt(byte[] cipherText, String password)
    {
        try{
            String key = "MZygpewJsCpR"+password;
            byte[] keyInBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(keyInBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(cipherText);
        }
        catch(Exception e)
        {
            return new byte[0];
        }
    }


    public static String desencriptarArchivo(String password)
    {
        try{
            Path path = Paths.get("archivoEncriptado.txt");
            byte[] archivoEncriptado = Files.readAllBytes(path);
            byte[] decryptedCipherText = AdvancedEncryptionStandard.decrypt(archivoEncriptado,password);
            return new String(decryptedCipherText);
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
            return  "";
        }
    }
}
