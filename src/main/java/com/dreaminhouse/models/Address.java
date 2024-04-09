package com.dreaminhouse.models;

/**
 * Address
 */
public class Address {
    private String neighborhood;
    private String street;
    private int number;
    private propertyComplement complement;

    public Address(String neighborhood, String street, int number, propertyComplement complement) {
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public propertyComplement getComplement() {
        return complement;
    }

    public void setComplement(propertyComplement complement) {
        this.complement = complement;
    }
}
