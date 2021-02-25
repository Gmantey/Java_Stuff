package com.goddy.Project4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project 4 - PurdueStudent
 * <p>
 * A class for a College student who goes to Purdue University
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class PurdueStudent extends CollegeStudent {

    private static ArrayList<String> idNums = new ArrayList<>();

    public PurdueStudent() {
    }

    public PurdueStudent(int age, String firstName, String lastName,
                         String stateOfResidency, String major, String housing) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateOfResidency = stateOfResidency;
        this.major = major;
        this.housing = housing;
        calculateTuition();
        this.id = generateID();
    }

    public PurdueStudent(String id) {
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
                this.tuition = CollegeConstants.getPurdueUniversityInStateTuition();
                break;
            default:
                this.tuition = CollegeConstants.getPurdueUniversityOutOfStateTuition();
        }
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getHousing() {
        return housing;
    }

    @Override
    public String getState() {
        return CollegeConstants.getPurdueUniversityState();
    }

    @Override
    public String generateID() {
        Random rand = new Random();
        int randint1 = rand.nextInt(11);
        int randint2 = rand.nextInt((9999999 - 1000000) + 1) + 1000000;
        String iddnum = String.valueOf(randint1) + "13" + String.valueOf(randint2);
        idNums.add(iddnum);
        return iddnum;
    }

    @Override
    public String getID() {
        return id;
    }


}
