package com.goddy.Homework8;
/**
 * Homework 8 -- CollegeStudent
 *
 * A SuperClass that allows a company to track information about IU and
 * Purdue Students
 *
 * @author Godfred Mantey, L01
 * @version March 19, 2020
 */
public class CollegeStudent {
    private String firstName;
    private String lastName;
    private String id;
    private double gpa;
    private Residency residency;
    private boolean livesOffCampus;
    private double dormCost;
    private double tuition;
    private double bookFees;
    private double financialAid;

    // First Constructor
    public CollegeStudent(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    // Second Constructor
    public CollegeStudent(String firstName, String lastName,
                          String id, double gpa, String residency,
                          boolean livesOffCampus) throws IllegalArgumentException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;
        this.residency = Residency.valueOf(residency);
        this.livesOffCampus = livesOffCampus;

        if (livesOffCampus) {
            this.dormCost = 500;
        } else this.dormCost = 800;

        if (gpa < 0) {
            throw new IllegalArgumentException("GPA needs to be above or equal to 0");
        }

        // Default Residency Setting
        if (Residency.valueOf(residency).equals(Residency.IN_STATE)) {
            this.tuition = 23000;
        } else if (Residency.valueOf(residency).equals(Residency.OUT_OF_STATE)) {
            this.tuition = 42000;
        } else if (Residency.valueOf(residency).equals(Residency.INTERNATIONAL)) {
            this.tuition = 44500;
        } else throw new IllegalArgumentException("Student residency must be one of the three specified statuses");

    }

    public double calculateYearlyCost() {
        // May have to adjust if the values are uninitialized.
        return tuition + bookFees + (dormCost * 12) - financialAid;
    }



    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Residency getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency =  Residency.valueOf(residency);
    }

    public boolean isLivingOffCampus() {
        return livesOffCampus;
    }

    public void setLivesOffCampus(boolean livesOffCampus) {
        this.livesOffCampus = livesOffCampus;
    }

    public double getDormCost() {
        return dormCost;
    }

    public void setDormCost(double dormCost) {
        this.dormCost = dormCost;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public double getBookFees() {
        return bookFees;
    }

    public void setBookFees(double bookFees) {
        this.bookFees = bookFees;
    }

    public double getFinancialAid() {
        return financialAid;
    }

    public void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
    }
}

