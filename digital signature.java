import java.security.*;
import java.util.Base64;

public class Main{

    public static void main(String[] args) throws Exception {
     
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

       
        String message = "Hello, World!";
        System.out.println(message);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signatureBytes = signature.sign();
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("Digital Signature: " + signatureBase64);
        
        // message = "bye";

       
        Signature verifySignature = Signature.getInstance("SHA256withRSA");
        verifySignature.initVerify(publicKey);
        verifySignature.update(message.getBytes());
        boolean verified = verifySignature.verify(Base64.getDecoder().decode(signatureBase64));
        if(verified)
        {
            System.out.println("Digital Signature Verified");
        }
        else
        {
            System.out.println("Digital Signature not verfied");
        }
    }
}
