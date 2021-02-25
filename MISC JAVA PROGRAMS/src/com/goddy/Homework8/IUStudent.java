package com.goddy.Homework8;
/**
 * Homework 8 -- IUStudent
 *
 * A subclass that describes a typical IU student
 *
 * @author Godfred Mantey, L01
 * @version March 19, 2020
 */
public class IUStudent extends CollegeStudent {

    private double transportationCost;

    public IUStudent(String firstName, String lastName, String id, double gpa,
                     String residency, boolean livesOffCampus) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        setBookFees(1034);
        if (livesOffCampus) {
           setTransportationCost(500);
        } else  setTransportationCost(100);

        if (gpa >= 3.75 && gpa <= 4.0) {
            setFinancialAid(4500);
        } else if (gpa >= 3.5 && gpa < 3.75) {
            setFinancialAid(3500);
        } else if (gpa >= 3.00 && gpa < 3.5) {
            setFinancialAid(2750);
        } else if (gpa >= 2.5 && gpa < 3.00) {
            setFinancialAid(2500);
        }
        // Residency Setting
        if (Residency.valueOf(residency).equals(Residency.IN_STATE)) {
            setTuition(10534);
        } else if (Residency.valueOf(residency).equals(Residency.OUT_OF_STATE)) {
            setTuition(34896);
        } else if (Residency.valueOf(residency).equals(Residency.INTERNATIONAL)) {
            setTuition(38314);
        }

    }
    public double calculateYearlyCost (){
        return getTuition() + getBookFees() + getTransportationCost() + (super.getDormCost() * 12) - getFinancialAid();
    }
    // Getters and Setters
    public double getTransportationCost() {
        return transportationCost;
    }
    public void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }
}
