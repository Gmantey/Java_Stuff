package com.goddy.Project4;

/**
 * Project 4 - CollegeStudent
 * <p>
 * An abstract class for a college student
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public abstract class CollegeStudent {
    protected double tuition;
    protected int age;
    protected String firstName;
    protected String lastName;
    protected String stateOfResidency;
    protected String major;
    protected String housing;
    protected String id;

    // Abstract Methods
    public abstract double getTuition();

    public abstract int getStudentAge();

    public abstract String getStudentFirstName();

    public abstract String getStudentLastName();

    public abstract String getStateOfResidence();

    public abstract String getFullName();

    public abstract void calculateTuition();

    public abstract String getMajor();

    public abstract String getHousing();

    public abstract String getState();

    public abstract String generateID();

    public abstract String getID();

}
