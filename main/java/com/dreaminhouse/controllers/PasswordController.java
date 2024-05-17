package com.dreaminhouse.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.dreaminhouse.models.Password;

/* PasswordController */
public class PasswordController {
    /* Constants about hash generation */
    public static int ITERATION_COUNT = 65536;
    public static int KEY_LENGTH = 256;

    public static byte[] generateSalt() {
        // Create salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] generateHash(String text, byte[] salt) {
        try {
            // Generate key spec and hashing factory
            KeySpec spec = new PBEKeySpec(text.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            // Generate secret key and return it
            return factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean checkHashes(byte[] hash1, byte[] hash2) {
        // comparison of byte arrays with the equals operator checks address,
        // not content - which is why you compare it with the Arrays
        return Arrays.equals(hash1, hash2);
    }

    public static Password createPassword(String password) {
        // Generate salt and hash
        byte[] salt = generateSalt();
        byte[] hash = generateHash(password, salt);

        // Safeguard
        if (hash == null) {
            return null;
        }

        // Instantiate password class and return it
        Password pw = new Password();
        pw.setPasswordSalt(salt);
        pw.setPasswordHash(hash);
        return pw;
    }
}
