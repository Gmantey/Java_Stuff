package com.goddy.Homework8;
/**
 * Homework 8 -- PurdueStudent
 *
 * A subclass that describes a typical Purdue student
 *
 * @author Godfred Mantey, L01
 * @version March 19, 2020
 */
public class PurdueStudent extends CollegeStudent  {
    private String major;

    public PurdueStudent(String firstName, String lastName, String id,
                         double gpa, String residency, boolean livesOffCampus, String major)  {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        this.major = major;

        switch (major) {
            case "Computer Science":
                setBookFees(200);
                break;
            case "Engineering":
                setBookFees(500);
                break;
            case "Liberal Arts":
                setBookFees(750);
                break;
            default:
                setBookFees(100);
        }
        if (gpa >= 3.75 && gpa <= 4.0) {
            setFinancialAid(5000);
        } else if (gpa >= 3.5 && gpa < 3.75) {
            setFinancialAid(4500);
        } else if (gpa >= 3.00 && gpa < 3.5) {
            setFinancialAid(3000);
        } else if (gpa >= 2.5 && gpa < 3.00) {
            setFinancialAid(2500);
        }
        // Residency Setting
        if (Residency.valueOf(residency).equals(Residency.IN_STATE)) {
            setTuition(9992);
        } else if (Residency.valueOf(residency).equals(Residency.OUT_OF_STATE)) {
            setTuition(28794);
        } else if (Residency.valueOf(residency).equals(Residency.INTERNATIONAL)) {
            setTuition(30954);
        }
    }

    public double calculateYearlyCost() {
        return getTuition() + getBookFees() + (super.getDormCost() * 12) - getFinancialAid();
    }
    // Getters and Setters
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
}
