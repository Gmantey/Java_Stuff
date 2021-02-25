package com.goddy.Project2;

/**
 * Project 1 -- Customer
 *
 * Collects information about a customer and calculates his
 * discount rate
 *
 * @author Godfred Mantey, L01
 * @version March 7, 2020
 *
 */
public class Customer {
    // fields
    private String name;
    private String address;
    private String zipCode;
    private int numRentals;

    public Customer(String name, String address, String zipCode, int numRentals) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.numRentals = numRentals;
    }
    // None Constructor
    public Customer() {
    }

    public double calculateDiscount() {
        double discount;
        discount = numRentals * 0.25 / 100;
        return  discount;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumRentals() {
        return numRentals;
    }

    public void setNumRentals(int numRentals) {
        this.numRentals = numRentals;
    }
}

