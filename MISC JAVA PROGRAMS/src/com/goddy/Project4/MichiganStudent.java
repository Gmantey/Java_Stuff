package com.goddy.Project4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project 4 - MichiganStudent
 * <p>
 * A class for a College student who goes to Michigan University
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class MichiganStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public MichiganStudent() {
    }

    public MichiganStudent(int age, String firstName, String lastName,
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

    public MichiganStudent(String id) {
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
            case "Michigan":
                this.tuition = CollegeConstants.getUniversityOfMichiganInStateTuition();
                break;
            default:
                this.tuition = CollegeConstants.getUniversityOfMichiganOutOfStateTuition();
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
        return CollegeConstants.getUniversityOfMichiganState();
    }

    @Override
    public String generateID() {
        Random rand = new Random();
        int randint1 = rand.nextInt(10);
        int randint2 = rand.nextInt(10);
        int randint3 = rand.nextInt(10);
        int randint4 = rand.nextInt(10);
        int randint5 = rand.nextInt(10);

        String iddnum = String.valueOf(randint1) + "3" + String.valueOf(randint2) + "3" +
                String.valueOf(randint3) + "3" + String.valueOf(randint4) + "3" + String.valueOf(randint5) + "3";
        idNums.add(iddnum);
        return iddnum;
    }

    @Override
    public String getID() {
        return id;
    }

}
