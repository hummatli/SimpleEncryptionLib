package com.example;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class Encryptor {

    private SecretKey key;
    Base64.Encoder base64encoder;
    Base64.Decoder base64decoder;

    public Encryptor(String yourSecretKeyPhrase) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec keySpec = new DESKeySpec(yourSecretKeyPhrase.getBytes("UTF8"), 10);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        key = keyFactory.generateSecret(keySpec);
        base64encoder = Base64.getEncoder();
        base64decoder = Base64.getDecoder();
    }

    public static Encryptor newInstance(String yourSecretKeyPhrase) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return new Encryptor(yourSecretKeyPhrase);
    }

    public static Encryptor newInstanceOrRetunNull(String yourSecretKeyPhrase){
        try {
            return new Encryptor(yourSecretKeyPhrase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String encode(String plainTextPassword) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        // ENCODE plainTextPassword String
        byte[] cleartext = plainTextPassword.getBytes("UTF8");

        Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return base64encoder.encodeToString(cipher.doFinal(cleartext));
        // now you can store it
    }

    public String encodeOrReturnNull(String plainTextPassword)  {
        try {
            return encode(plainTextPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decode(String encryptedPwd) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {

        // DECODE encryptedPwd String
        byte[] encrypedPwdBytes = base64decoder.decode(encryptedPwd);

        Cipher cipher = Cipher.getInstance("DES");// cipher is not thread safe
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String((cipher.doFinal(encrypedPwdBytes)), "UTF-8");
    }

    public String decodeOrReturnNull(String encryptedPwd) {
        try {
            return decode(encryptedPwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}