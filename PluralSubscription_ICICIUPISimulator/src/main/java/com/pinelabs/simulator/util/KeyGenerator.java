package com.pinelabs.simulator.util;


import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Service
public class KeyGenerator {

    private static String path="src/main/resources/key";

    public static void main(String args[]) {

        try {

            KeyPairGenerator generator = KeyPairGenerator.getInstance(Constants.RSA);
            generator.initialize(Constants.KEY_SIZE_1024);
            KeyPair pair = generator.generateKeyPair();
            saveKeyPair(pair);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void saveKeyPair( KeyPair keyPair) throws IOException, FileNotFoundException {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        // Store Public Key.
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
                publicKey.getEncoded());
        FileOutputStream fos = new FileOutputStream(path + Constants.PUBLIC_KEY);
        fos.write(x509EncodedKeySpec.getEncoded());
        fos.close();
        // Store Private Key.
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                privateKey.getEncoded());
        fos = new FileOutputStream(path + Constants.PRIVATE_KEY);
        fos.write(pkcs8EncodedKeySpec.getEncoded());
        fos.close();
    }


}
