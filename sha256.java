import java.security.MessageDigest;

public class SHA256Hashing {

    public static String hash(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {
        String originalData = "Hello, World!";
        System.out.println("Original Data: " + originalData);

        String hashedData = hash(originalData);
        System.out.println("SHA-256 Hash: " + hashedData);
    }
}
