package com.goddy.Project2;

import java.util.Scanner;
/**
 * Project 1 -- CarRentalAgency
 *
 * Utilizes other classes to implement an interactive program that
 * implement multiple functionality based on the user input and choices
 * user only has 4 option
 * Rent or buy a car, calculate salary and quit program
 *
 * @author Godfred Mantey, L01
 * @version March 7, 2020
 */
public class CarRentalAgency {
    Scanner input0 = new Scanner(System.in);
    Customer customer0 = new Customer();
    Employee employee0 = new Employee();
    Car car = new Car();

    // Main Method
    public static void main(String[] args) {
        CarRentalAgency methods = new CarRentalAgency(); // In order to use
        methods.done();
    }
    public void done() {
        int option = 0;
        // Prompt User for input
        System.out.println("Hello! What would you like to do?");
        do {
            System.out.printf("1. Rent a Car\n2. Buy a Car\n3. Calculate Salary\n4. Quit\n");
            option = input0.nextInt();
            input0.nextLine();
            if (option < 1 || option > 4) {
                System.out.printf("Invalid input!\nPlease enter a number between 1 and 4!\n");
            } else if (option == 4) {
                System.out.println("Shutting down the program!");
                break;
            }
            switch(option) {
                case 1: prompt();
                        option1();
                    break;
                case 2: prompt();
                        option2();
                    break;
                case 3: option3();
                    break;
            }
        } while (option != 4);
    }

    // Universal Prompt
    public void prompt() {
        double answer = 0;
        boolean decision = false;
        String in;
        int in2;
        customer0.setName(collectStrings("Please enter the Customer's information:\nName:"));
        customer0.setAddress(collectStrings("Address:"));
        customer0.setZipCode(collectStrings("Zip Code:"));
        customer0.setNumRentals((int)checkinput("Number of Previous Rentals:"));

        System.out.println("Please enter the Car's information:\nClassification Type:");
        in = input0.nextLine();
        Classification enumValue = Classification.valueOf(in);
        car.setType(enumValue);

        car.setMaxSeating((int)checkinput("Max Seating:"));
        car.setTowingCapacity((int)checkinput("Towing Capacity:"));
        car.setFuelEconomy(checkinput("Fuel Economy:"));
        car.setMake(collectStrings("Make:"));
        car.setModel(collectStrings("Model:"));
        car.setVin(collectStrings("Vin:"));
        car.setPurchasePrice(checkinput("Purchase Price:"));
        car.setMileage((int)checkinput("Mileage:"));
    }

    // Option 1
    public void option1() {
        double answer = 0;
        boolean decision = false;
        String in;

        System.out.println("Does " + customer0.getName() + " want insurance?");
        in = input0.nextLine();

        while (in != null) {
            if ((in.equals("Yes")) || (in.equals("yes")) || (in.equals("y")) || (in.equals("No"))
                    || (in.equals("no")) || (in.equals("n"))) {
                if ((in.equals("Yes")) || (in.equals("yes")) || (in.equals("y"))) {
                    decision = true;
                }
                break;
            } else {
                System.out.println("Invalid input!\nPlease enter either Yes/yes/y or No/no/n.");
                in = input0.nextLine();
            }
        }
        answer =  car.calculateRate((int)checkinput("How many days are in the rental period"), decision);
        answer -= (customer0.calculateDiscount()) * answer ;
        System.out.printf("The total price is: $%.2f.\n", answer);
    }
    private void option2() {
        System.out.printf("The total price is: $%.2f.\n", car.calculateSellPrice());
    }
    private void option3() {
        employee0.setName(collectStrings("Please enter the Employee's information:\nName:"));
        employee0.setYearsWorked((int)checkinput("Years Worked:"));
        employee0.setTotalRentals((int)checkinput("Total Rentals:"));
        employee0.setBaseSalary(checkinput("Base Salary:"));
        employee0.setId((int)checkinput("Id:"));
        System.out.printf(employee0.getName() + "'s salary is: $%.2f.\n", employee0.calculateSalary());
    }
    // Method Collecting and for Checking numerical inputs
    private double checkinput(String prompt) {
        double choice;
        System.out.println(prompt);
        do {
            choice = input0.nextDouble();
            input0.nextLine();
            if (choice < 0) {
                System.out.println("Invalid Input!");
                System.out.println("Please enter a number greater than or equal to 0.");
            }

        } while (choice < 0);
        return choice;
    }
    // Method for Collecting Strings
    private String collectStrings(String prompt) {
        String choice;
        System.out.println(prompt);
        choice = input0.nextLine();
        return choice;
    }
}
