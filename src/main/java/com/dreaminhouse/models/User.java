package com.dreaminhouse.models;

import java.util.ArrayList;
import java.time.LocalDateTime;
// import java.awt.image.BufferedImage;

/**
 * User
 */
public class User {
    /* Metadata */
    private int userId;
    private Reputation reputation;
    private ArrayList<Connection> connections;
    private boolean isAdministrator;
    private boolean isDeleted;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;

    /* Login Credentials */
    private String userName;
    private byte[] passwordHash; /* use PBKDF2 */ 
    private int recoveryCode;

    /* User Credentials */
    // private String firstName;
    // private String familyName;
    // private String contactEmail;
    // private String contactPhone;
    // private BufferedImage profilePicture;
    // private Address residenceAddress;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Reputation getReputation() {
        return reputation;
    }

    public void setReputation(Reputation reputation) {
        this.reputation = reputation;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connection> connections) {
        this.connections = connections;
    }

    public boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(int recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    // public String getFirstName() {
    //     return firstName;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public String getFamilyName() {
    //     return familyName;
    // }

    // public void setFamilyName(String familyName) {
    //     this.familyName = familyName;
    // }

    // public String getContactEmail() {
    //     return contactEmail;
    // }

    // public void setContactEmail(String contactEmail) {
    //     this.contactEmail = contactEmail;
    // }

    // public String getContactPhone() {
    //     return contactPhone;
    // }

    // public void setContactPhone(String contactPhone) {
    //     this.contactPhone = contactPhone;
    // }

    // public BufferedImage getProfilePicture() {
    //     return profilePicture;
    // }

    // public void setProfilePicture(BufferedImage profilePicture) {
    //     this.profilePicture = profilePicture;
    // }

    // public Address getResidenceAddress() {
    //     return residenceAddress;
    // }

    // public void setResidenceAddress(Address residenceAddress) {
    //     this.residenceAddress = residenceAddress;
    // }
}
