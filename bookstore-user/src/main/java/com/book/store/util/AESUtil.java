package com.book.store.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String AES_SECRET_KEY = "cWzz0AEkM+gGurDLOHWf1A==";
    private static final String ALGORITHM = "AES";

    public static String encrypt(String input) throws Exception {
        SecretKeySpec key = new SecretKeySpec(AES_SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedInput) throws Exception {
        SecretKeySpec key = new SecretKeySpec(AES_SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
        return new String(decryptedBytes);
    }
}
