package com.goddy.Lab13;

import javax.swing.*;
import java.util.Scanner;

public class BusinessCard {

    public static void main(String[] args) {
        // Input Variables
        String name;       // variable for the first name
        String age;          // variable for the year
        String gpa;        // variable for the gpa
        String major;      // variable for the first name of the major
        String email;      // variable for email

        int greeting = JOptionPane.showConfirmDialog(null, "Would you like to generate a business card?",
                "Business Card Generator", JOptionPane.YES_NO_OPTION);

        if (greeting == JOptionPane.NO_OPTION) {
            return;
        }
        do {
            name = JOptionPane.showInputDialog(null, "What is your name?", "Business Card Generator",
                    JOptionPane.QUESTION_MESSAGE);
            age = JOptionPane.showInputDialog(null, "What is your age?", "Business Card Generator",
                    JOptionPane.QUESTION_MESSAGE);
            gpa = JOptionPane.showInputDialog(null, "What is your GPA?", "Business Card Generator",
                    JOptionPane.QUESTION_MESSAGE);
            double gpaNum = Double.parseDouble(gpa);
            gpa = String.format("%.2f", gpaNum);
            major = JOptionPane.showInputDialog(null, "What is your major?", "Business Card Generator",
                    JOptionPane.QUESTION_MESSAGE);
            email = JOptionPane.showInputDialog(null, "What is your email?", "Business Card Generator",
                    JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Name: " + name + "\nAge: " + age +
                            "\nGPA: " + gpa + "\nMajor: " + major + "\nEmail:  " + email,
                    "Business Card", JOptionPane.INFORMATION_MESSAGE);
            greeting = JOptionPane.showConfirmDialog(null, "Would you like to generate another business card?",
                    "Here is your business Card!", JOptionPane.YES_NO_OPTION);

        } while (greeting == JOptionPane.YES_OPTION);
    }
}

