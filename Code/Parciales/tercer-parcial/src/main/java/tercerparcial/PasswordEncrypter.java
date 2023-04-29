package tercerparcial;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * PasswordEncypter using the algorithm hash SHA-256
 * Methods -> static 
 * 
 */

public class PasswordEncrypter {
    public static String encryptHashSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // * Turns the password into a BytesArray and processes it using the Object digest
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // * Method that turns a BytesArray into a HexString 
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
