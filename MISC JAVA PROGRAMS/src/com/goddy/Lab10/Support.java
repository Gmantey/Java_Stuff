package com.goddy.Lab10;

public class Support extends Employee {

    private double performanceBonus;

    // Constructors

    public Support() {
        super();
        this.performanceBonus = 0;
    }

    public Support(double yearlySalary, boolean temporary, boolean insured, double performanceBonus) {
        super(yearlySalary, temporary, insured);
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateCompensation() {
        return getYearlySalary() + getPerformanceBonus();
    }
    public void printInfo() {
        System.out.printf("Base Salary: %.2f\n", getYearlySalary());
        System.out.println("Temporary: " + isTemporary());
        System.out.println("Insured: "+ isInsured());
        System.out.printf("Total Compensation: %.2f\n", calculateCompensation());
    }

    // Getters and Setters
    public double getPerformanceBonus() {
        return performanceBonus;
    }
    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }
}
