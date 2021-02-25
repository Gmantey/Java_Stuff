package com.goddy.Project2;
/**
 * Project 1 -- Car
 *
 * Collects information about a car and calculates its
 * rate and sell price
 *
 * @author Godfred Mantey, L01
 * @version March 7, 2020
 *
 */
public class Car {
    // Fields
    private Classification type;
    private int maxSeating;
    private int towingCapacity;
    private double fuelEconomy;
    private String make;
    private String model;
    private String vin;
    private double purchasePrice;
    private int mileage;

    public Car(Classification type, int maxSeating, int towingCapacity,
               double fuelEconomy, String make, String model, String vin,
               double purchasePrice, int mileage) {
        this.type = type;
        this.maxSeating = maxSeating;
        this.towingCapacity = towingCapacity;
        this.fuelEconomy = fuelEconomy;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.purchasePrice = purchasePrice;
        this.mileage = mileage;
    }
    public Car() {
    }
    public static void main(String[] args) {

    }
    // Calculate Rate Class
    public double calculateRate(int numDays, boolean insurance) {
        double totalPrice = 20;
        totalPrice *= numDays;
        if (type.equals(Classification.SUV) || type.equals(Classification.PICKUP)) {  // Ask a question about it
            totalPrice += numDays * 30;
        } else if (type.equals(Classification.ECONOMY) || type.equals(Classification.COMPACT)) {
            totalPrice += numDays * 10;
        } else if (type.equals(Classification.PREMIUM) || type.equals(Classification.SPORT)) {
            totalPrice += numDays * 20;
        } else if (type.equals(Classification.LUXURY)) {
            totalPrice += numDays * 40;
        }
        if (insurance) {
            totalPrice += numDays * 15;
        }
        return totalPrice;
    }
    // Method for Calculating Selling Price
    public double calculateSellPrice() {
        double sellPrice = 0;
        sellPrice = this.purchasePrice  - (this.mileage * 0.05);
        return sellPrice;
    }
// Getters and Setters
    public Classification getType() {
        return type;
    }
    public int getMaxSeating() {
        return maxSeating;
    }
    public int getTowingCapacity() {
        return towingCapacity;
    }
    public double getFuelEconomy() {
        return fuelEconomy;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getVin() {
        return vin;
    }
    public double getPurchasePrice() {
        return purchasePrice;
    }
    public int getMileage() {
        return mileage;
    }
    public void setType(Classification type) {
        this.type = type;
    }
    public void setMaxSeating(int maxSeating) {
        this.maxSeating = maxSeating;
    }
    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }
    public void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}











