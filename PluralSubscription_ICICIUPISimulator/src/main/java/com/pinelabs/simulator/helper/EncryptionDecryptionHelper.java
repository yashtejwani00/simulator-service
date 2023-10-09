package com.pinelabs.simulator.helper;

import com.pinelabs.simulator.dto.EncryptedRequest;
import com.pinelabs.simulator.util.Constants;
import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Component
public class EncryptionDecryptionHelper {

    @Autowired
    private Environment env;

    Logger logger = LoggerFactory.getLogger(EncryptionDecryptionHelper.class);
    private static String pinePublicKey ="C:\\Users\\yashwant.tejwani\\pinelabs\\git\\PluralSubscription_ICICIUPISimulator\\src\\main\\resources\\key\\af5c92969f7433bbpublic.pem";
    private static String iciciPrivateKey ="C:\\Users\\yashwant.tejwani\\pinelabs\\git\\PluralSubscription_ICICIUPISimulator\\src\\main\\resources\\key\\iciciprivate.pem";

    public static byte[] getRandomValueWithSize(int size) {
        byte[] iv = new byte[size];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    // Function to initialize a vector with an arbitrary value
    public static byte[] createInitializationVector() {
        // Used with encryption
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext, the key with an initialization vector to convert plainText into CipherText.
    public EncryptedRequest encryptRequest(String plainText) throws Exception {
        logger.info("text for encryption: {}", plainText);

        EncryptedRequest simulatorRequest = new EncryptedRequest();

        //Generate Symmetric key
        byte[] sessionKey = getRandomValueWithSize(16);
        byte[] initializationVector = createInitializationVector();

        PublicKey publicKey = getPublicKey();

        Cipher cipher = Cipher.getInstance(Constants.RSA_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encKey = cipher.doFinal(sessionKey);

        byte[] encryptKey = encode(encKey);
        simulatorRequest.setEncryptedKey(new String(encryptKey));
        Cipher encCipher = Cipher.getInstance(Constants.AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        SecretKeySpec skeySpec = new SecretKeySpec(sessionKey, Constants.AES);
        encCipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encText = encCipher.doFinal(plainText.getBytes());

        byte[] bytes = ArrayUtils.addAll(ivParameterSpec.getIV(), encText);
        byte[] encryptedData = encode(bytes);
        simulatorRequest.setEncryptedData(new String(encryptedData));

        return simulatorRequest;
    }

    // This function performs the reverse operation of the do_AESEncryption function.
    // It converts ciphertext to the plaintext using the key.
    public String decryptData(EncryptedRequest simulatorRequest) throws Exception {
        logger.info("inside of decryptData method, simulatorRequest: {}", simulatorRequest.toString());
        byte[] decryptedText = new byte[0];

        PrivateKey privatekey = getPrivateKey();
        byte[] decodedData = Base64.getDecoder().decode(simulatorRequest.getEncryptedData());
        //get IV from decoded Data
        IvParameterSpec ivParameterSpec = new IvParameterSpec(getFirst16Bytes(decodedData));
        //get Session Key
        Cipher cipher = Cipher.getInstance(Constants.RSA_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privatekey);
        byte[] decodedKey = Base64.getDecoder().decode(simulatorRequest.getEncryptedKey());
        byte[] sessionKey = cipher.doFinal(decodedKey);

        SecretKeySpec spec = new SecretKeySpec(sessionKey, Constants.AES);
        Cipher aesChiper = Cipher.getInstance(Constants.AES_CIPHER_ALGORITHM);
        aesChiper.init(Cipher.DECRYPT_MODE, spec, ivParameterSpec);
        //remove IV from the decode data of cipher text
        byte[] originalEncData = Arrays.copyOfRange(decodedData, Constants.SIXTEEN_DIGIT, decodedData.length);
        decryptedText = aesChiper.doFinal(originalEncData);

        String decryptedString = new String(decryptedText);
        logger.info("payload after decryption: {}", decryptedString);
        return decryptedString;
    }

    private byte[] encode(byte[] data){
        return Base64.getEncoder().encode(data);
    }

    private static byte[] getFirst16Bytes(byte[] decodedData) {
        return Arrays.copyOf(decodedData,Constants.SIXTEEN_DIGIT);
    }

    private static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        FileInputStream fis = new FileInputStream(iciciPrivateKey);
        PemReader pemReader = new PemReader(new InputStreamReader(fis));
        PemObject pemObject = pemReader.readPemObject();
        byte[] content = pemObject.getContent();
        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
        return factory.generatePrivate(privKeySpec);
    }

    private static PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        FileInputStream fis = new FileInputStream(pinePublicKey);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PemReader pemReader = new PemReader(new InputStreamReader(fis));
        PemObject pemObject = pemReader.readPemObject();
        byte[] content = pemObject.getContent();
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
        return factory.generatePublic(pubKeySpec);
    }



}

