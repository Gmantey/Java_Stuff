package com.goddy.Lab10;

public abstract class Employee {

    private double yearlySalary;
    private boolean temporary;
    private boolean insured;

    // Constructor

    public Employee () {
        this.yearlySalary = 45000.00;
        this.temporary = false;
        this.insured = false;
    }

    public Employee (double yearlySalary, boolean temporary, boolean insured) {
        this.yearlySalary = yearlySalary;
        this.temporary = temporary;
        this.insured = insured;
    }

    public abstract double calculateCompensation ();
    public void printInfo (){
        System.out.printf("Base Salary: %.2f\n", getYearlySalary());
        System.out.println("Temporary: " + isTemporary());
        System.out.println("Insured: "+ isInsured());
    }

    // Getters and Setters
    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
