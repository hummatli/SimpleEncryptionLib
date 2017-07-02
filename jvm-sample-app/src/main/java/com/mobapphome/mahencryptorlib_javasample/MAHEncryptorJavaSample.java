package com.mobapphome.mahencryptorlib_javasample;

import com.mobapphome.mahencryptorlib.MAHEncryptor;

/**
 * This is MAHEncryptorLib sample created test encryptor lib on non-Android java programs.
 * Created by Sattar Hummatli on 8/5/16.
 */
public class MAHEncryptorJavaSample {
    static public void main(String[] arg) {
        //Your key phrase mus be at least 18 character other through exeption
        MAHEncryptor mahEncryptor = MAHEncryptor.newInstanceOrRetunNull("This is sample SecretKeyPhrase");

        String strForEncryption = "This is MAHEncryptorLib java sample";
        String encrypted = mahEncryptor.encodeOrReturnNull(strForEncryption);
        System.out.println("encrypted = " + encrypted);

        String decrypted = mahEncryptor.decodeOrReturnNull(encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
