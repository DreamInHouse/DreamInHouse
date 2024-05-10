package com.dreaminhouse.models;

import java.nio.charset.StandardCharsets;

/**
 * Password
 */
public class Password {
    private byte[] passwordHash;
    private byte[] passwordSalt;

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public String getPasswordString() {
        return new String(passwordHash, StandardCharsets.UTF_8);
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }
}
