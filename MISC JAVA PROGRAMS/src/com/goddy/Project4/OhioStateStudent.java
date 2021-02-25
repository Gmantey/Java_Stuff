package com.goddy.Project4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project 4 - OhioStateStudent
 * <p>
 * A class for a College student who goes to Ohio State University
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class OhioStateStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public OhioStateStudent() {
    }

    public OhioStateStudent(int age, String firstName, String lastName,
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

    public OhioStateStudent(String id) {
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
            case "Ohio":
                this.tuition = CollegeConstants.getOhioStateUniversityInStateTuition();
                break;
            default:
                this.tuition = CollegeConstants.getOhioStateUniversityOutOfStateTuition();
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
        return CollegeConstants.getOhioStateUniversityState();
    }

    @Override
    public String generateID() {
        Random rand = new Random();
        int randint1 = rand.nextInt(10);
        int randint2 = rand.nextInt(10);
        int randint3 = rand.nextInt(10);
        int randint4 = rand.nextInt(10);
        int randint5 = rand.nextInt(10);

        String iddnum = String.valueOf(randint1) + "1" + String.valueOf(randint2) + "0" +
                String.valueOf(randint3) + "0" + String.valueOf(randint4) + "1" + String.valueOf(randint5) + "0";
        idNums.add(iddnum);
        return iddnum;
    }

    @Override
    public String getID() {
        return id;
    }

}
