package com.goddy.Project4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project 4 - IndianaStudent
 * <p>
 * A class for a College student who goes to IndianaState
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class IndianaStudent extends CollegeStudent {

    private static ArrayList<String> idNums = new ArrayList<>();

    // Constructors

    public IndianaStudent() {
    }

    public IndianaStudent(int age, String firstName, String lastName,
                          String stateOfResidence, String major, String housing) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateOfResidency = stateOfResidence;
        this.major = major;
        this.housing = housing;
        calculateTuition();
        this.id = generateID();
    }

    public IndianaStudent(String id) {
        this.id = id;
    }

    @Override
    public double getTuition() {
        return tuition;
    }

    @Override
    public int getStudentAge() {
        return age;
    }

    @Override
    public String getStudentFirstName() {
        return firstName;
    }

    @Override
    public String getStudentLastName() {
        return lastName;
    }

    @Override
    public String getStateOfResidence() {
        return stateOfResidency;
    }

    @Override
    public String getFullName() {
        return getStudentFirstName() + " " + getStudentLastName();
    }

    @Override
    public void calculateTuition() {
        switch (getStateOfResidence()) {
            case "Indiana":
                this.tuition = CollegeConstants.getIndianaUniversityInStateTuition();
                break;
            default:
                this.tuition = CollegeConstants.getIndianaUniversityOutOfStateTuition();
        }
    }

    @Override
    public String getMajor() {
        return major;
    }

    @Override
    public String getHousing() {
        return housing;
    }

    @Override
    public String getState() {
        return CollegeConstants.getIndianaUniversityState();
    }

    @Override
    public String generateID() {
        Random rand = new Random();
        int randint = rand.nextInt((9999999 - 1000000) + 1) + 1000000;
        idNums.add("8" + String.valueOf(randint) + "21");
        return "8" + String.valueOf(randint) + "21";
    }

    @Override
    public String getID() {
        return id;
    }
}
