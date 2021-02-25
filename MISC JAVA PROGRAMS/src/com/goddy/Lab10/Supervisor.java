package com.goddy.Lab10;

public class Supervisor extends Employee{
    private int teamSize;

    public Supervisor() {
        super();
        this.teamSize = 0;
    }

    public Supervisor(double yearlySalary, boolean temporary, boolean insured, int teamSize) {
        super(yearlySalary, temporary, insured);
        this.teamSize = teamSize;
    }

    // Methods
    @Override
    public double calculateCompensation() {
        return getYearlySalary() + (getTeamSize() * 2000);
    }
    public void printInfo() {
        System.out.printf("Base Salary: %.2f\n", getYearlySalary());
        System.out.println("Temporary: " + isTemporary());
        System.out.println("Insured: "+ isInsured());
        System.out.println("Team Size: " + getTeamSize());
        System.out.printf("Total Compensation: %.2f\n", calculateCompensation());
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
