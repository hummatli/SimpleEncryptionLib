package com.example;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by settar on 8/5/16.
 */
public class SampleEncryption {
    static public void main(String[] arg) {


            Encryptor encryptor = Encryptor.newInstanceOrRetunNull("This is sample key");
            String encrypted = encryptor.encodeOrReturnNull("May name is Sattar");
            System.out.println("encrypted = " + encrypted);
            String decrypted = encryptor.decodeOrReturnNull(encrypted);
            System.out.println("decrypted = " + decrypted);


    }
}
