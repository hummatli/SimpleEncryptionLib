package com.mobapphome.simpleencryptorlib;

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

/**
 * This is SimpleEncryptor class. Main class of MAHEncryptorLib.
 * Created by Sattar Hummatli on 8/5/16.
 */

public class SimpleEncryptor {

    private SecretKey key;
    Base64.Encoder base64encoder;
    Base64.Decoder base64decoder;


    private SimpleEncryptor(String yourSecretKeyPhrase) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec keySpec = new DESKeySpec(yourSecretKeyPhrase.getBytes("UTF8"), 10);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        key = keyFactory.generateSecret(keySpec);
        base64encoder = Base64.getEncoder();
        base64decoder = Base64.getDecoder();
    }

    /**
     * Initializer of SimpleEncryptor
     * @param yourSecretKeyPhrase
     * @return SimpleEncryptor object or throughs exception
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     */
    public static SimpleEncryptor newInstance(String yourSecretKeyPhrase) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return new SimpleEncryptor(yourSecretKeyPhrase);
    }

    /**
     * Initializer of SimpleEncryptor
     * @param yourSecretKeyPhrase
     * @return SimpleEncryptor object or null if throughs exception
     */
    public static SimpleEncryptor newInstanceOrRetunNull(String yourSecretKeyPhrase){
        try {
            return new SimpleEncryptor(yourSecretKeyPhrase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Encode method
     * @param plainText
     * @return Encoded string
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public String encode(String plainText) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        // ENCODE plainText String
        byte[] cleartext = plainText.getBytes("UTF8");

        Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return base64encoder.encodeToString(cipher.doFinal(cleartext));
        // now you can store it
    }

    /**
     * Encode method
     * @param plainText
     * @return Encoded string or null if throughs exception
     */
    public String encodeOrReturnNull(String plainText)  {
        try {
            return encode(plainText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Decode method
     * @param encryptedText
     * @return Decoded string
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws UnsupportedEncodingException
     */
    public String decode(String encryptedText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {

        // DECODE encryptedText String
        byte[] encrypedPwdBytes = base64decoder.decode(encryptedText);

        Cipher cipher = Cipher.getInstance("DES");// cipher is not thread safe
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String((cipher.doFinal(encrypedPwdBytes)), "UTF-8");
    }

    /**
     * Decode method
     * @param encryptedText
     * @return Decoded string or null if throughs exception
     */
    public String decodeOrReturnNull(String encryptedText) {
        try {
            return decode(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}