package com.mobapphome.simpleencryptorlib_javasample;

import com.mobapphome.simpleencryptorlib.SimpleEncryptor;

/**
 * This is MAHEncryptorLib sample created test encryptor lib on non-Android java programs.
 * Created by Sattar Hummatli on 8/5/16.
 */
public class SampleEncryptorJavaSample {
    static public void main(String[] arg) {
        //Your key phrase mus be at least 18 character other through exeption
        SimpleEncryptor simpleEncryptor = SimpleEncryptor.newInstanceOrRetunNull("This is sample SecretKeyPhrase");

        String strForEncryption = "This is MAHEncryptorLib java sample";
        String encrypted = simpleEncryptor.encodeOrReturnNull(strForEncryption);
        System.out.println("encrypted = " + encrypted);

        String decrypted = simpleEncryptor.decodeOrReturnNull(encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
