/**
 * Homework 01 -- Business Card
 *
 * This program prompts a student to enter in their name,
 * Birth year, GPA, major,and email
 *
 * Reference Scanner class in Java to help with
 * consuming newline after using 'gpa = input.nextDouble();'
 * Link: https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 *
 * @author Godfred Mantey, Lab sec 1 (LE1)
 * @version January 22, 2020
 *
 */

package com.goddy;
import java.util.Scanner;

public class BusinessCard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Imports the Scanner
        // class and makes an object

        // Input Variables
        String name;       // variable for the first name
        int year;          // variable for the year
        double gpa;        // variable for the gpa
        String major;      // variable for the first name of the major
        String email;      // variable for email

        // prompts and stores the user's first and last name
        System.out.print("Enter your Name: ");
        name = input.nextLine();

        System.out.print("Enter your Year of Birth: ");
        year = input.nextInt();

        System.out.print("Enter your GPA: ");
        gpa = input.nextDouble();
        input.nextLine(); // consumes the new line

        System.out.print("Enter your Major: ");
        major = input.nextLine();

        System.out.print("Enter your Email: ");
        email = input.next();

        // Output
        System.out.printf("%nName:  %s%n" , name );
        System.out.println("Age:   " + (2020 - year)); // calculate the age of the individual
        System.out.printf("GPA:   %.2f%n" , gpa);
        System.out.println("Major: " + major);
        System.out.print("Email: " + email);
    }
}