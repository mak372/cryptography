import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Main {

    private static final String ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "abcdefghijklmnop"; // Sample encryption key

    public static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    private static Key generateKey() {
        return new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ALGORITHM);
    }

    public static void main(String[] args) throws Exception {
        String originalData = "Hello, World!";
        System.out.println("Original Data: " + originalData);

        String encryptedData = encrypt(originalData);
        System.out.println("Encrypted Data: " + encryptedData);

        String decryptedData = decrypt(encryptedData);
        System.out.println("Decrypted Data: " + decryptedData);
    }
}
