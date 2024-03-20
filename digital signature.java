import java.security.*;
import java.util.Base64;

public class Main{

    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Original message
        String message = "Hello, World!";
        System.out.println(message);

        // Generate signature
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signatureBytes = signature.sign();
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("Digital Signature: " + signatureBase64);
        
        // message = "bye";

        // Verify signature
        Signature verifySignature = Signature.getInstance("SHA256withRSA");
        verifySignature.initVerify(publicKey);
        verifySignature.update(message.getBytes());
        boolean verified = verifySignature.verify(Base64.getDecoder().decode(signatureBase64));
        System.out.println("Signature Verification: " + verified);
    }
}
