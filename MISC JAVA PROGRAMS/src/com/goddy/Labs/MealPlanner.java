package com.goddy.Labs;

import java.util.Scanner;

/**
 * Lab 1 - MealPlanner
 *
 * For this Challenge, you will be creating a meal planning tool. Users will
 * enter the appetizer, main course and dessert into the program and it will
 * print out a summary fo the information for review
 *
 * n/a
 *
 * @author Godfred Mantey, lab section 1 (LE1)
 * @version January 22, 2020
 *
 */
public class MealPlanner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // import Scanner class and creats the object

        // input Variables
        String appet;
        String mCourse;
        String dessert;

        // Collects input from the User
        System.out.println("Welcome to the Purdue Meal Planner!\nWhat is the appetizer?"); // Greeting + first User
                                                                                           // prompt question
        appet = input.nextLine();
        System.out.println("What is the main course?");
        mCourse = input.nextLine();
        System.out.println("What is the dessert?");
        dessert = input.nextLine();

        // Output
        System.out.println("Here's your summary!");
        System.out.println("Appetizer: " + appet);
        System.out.println("Main Course: " + mCourse);
        System.out.println("Dessert: " + dessert);
        System.out.println("Thank you for using our program!");
    }
}
