package com.goddy.Homework.HW1;
import java.util.Scanner;
/**
 * Project 1 - Wordiness
 *
 * The program simulates a word-centered magazine.
 * Magazine has games available to the user as well as tools
 * they can find useful
 *
 * a list of your sources of help (if any)
 *
 * @author Godfred Mantey, L01
 * @version February 19, 2020
 *
 */
public class Wordiness {

    // Can be used by all the methods in the class.
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        Wordiness wordiness = new Wordiness();
        choice = wordiness.menu();

        switch(choice) {
            case 1: wordiness.textFillerGame();
            break;
            case 2: wordiness.decryption();
            break;
            case 3: wordiness.citationManager();
            break;
            case 4: wordiness.subcription();
            break;
        }
        System.out.println("Thank you for using Wordiness!");
    }
    // Menu method
    public int menu() {
        int choice;
        System.out.println("Welcome to Wordiness!\nWhat would you like to do?\n1. " +
                "Text Filler Game\n2. Decryption Puzzle Solver\n3. Citation Manager\n4." +
                " Subscription Manager");
        choice = input.nextInt();
        return choice;
    }


    // Text filler Game method

    public void textFillerGame() {
        // Greeting Message

        // Input Variables
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        String answer5;
        String answer6;
        String answer7;
        String answer8;
        String answer9;
        String answer10;
        int answer11;
        String answer12;
        String answer13;
        String answer14;
        int answer15;

        input.nextLine();
        System.out.printf("Welcome to the Text Filler Game!\nPlease provide the following:\n");
        System.out.println("Adjective:");
        answer1 = input.nextLine();
        System.out.println("Nationality:");
        answer2 = input.nextLine();
        System.out.println("Name:");
        answer3 = input.nextLine();
        System.out.println("Noun:");
        answer4 = input.nextLine();
        System.out.println("Adjective:");
        answer5 = input.nextLine();
        System.out.println("Noun:");
        answer6 = input.nextLine();
        System.out.println("Adjective:");
        answer7 = input.nextLine();
        System.out.println("Adjective:");
        answer8 = input.nextLine();
        System.out.println("Plural Noun:");
        answer9 = input.nextLine();
        System.out.println("Noun:");
        answer10 = input.nextLine();
        System.out.println("Number:");
        answer11 = input.nextInt();
        input.nextLine();
        System.out.println("Plural Shape:");
        answer12 = input.nextLine();
        System.out.println("Food:");
        answer13 = input.nextLine();
        System.out.println("Food:");
        answer14 = input.nextLine();
        System.out.println("Number:");
        answer15 = input.nextInt();
        input.nextLine();

        System.out.printf("Pizza was invented by a %s %s chef named %s. " +
                "To make a pizza, you\n", answer1, answer2, answer3);
        System.out.printf("need to take a lump of %s, and make a thin, " +
                "round %s %s. Then you cover it\n", answer4, answer5, answer6);
        System.out.printf("with %s sauce, %s cheese, and fresh chopped " +
                "%s. Next you have to\n", answer7, answer8, answer9);
        System.out.printf("bake it in a very hot %s. When it is done, " +
                "cut it into %d %s. Some kids\n", answer10, answer11, answer12);
        System.out.printf("like %s pizza the best, but my favorite is " +
                "the %s pizza. If I could, I would eat pizza\n%d times a day!\n", answer13, answer14, answer15);
    }
    // Decryption Method
    public void decryption() {

        input.nextLine();
        String answer;
        System.out.println("Welcome to the Decryption Puzzle Solver!");
        System.out.println("Please enter a 10-character encrypted String:");
        answer = input.nextLine();

        String part1 = answer.substring(0, 4);
        String part2 = answer.substring(5, 11);
        answer = part1 + answer.charAt(10) + part2;
        answer = answer.replace('?', 'e');
        part1 = answer.substring(0, 5);
        part2 = answer.substring(5, 10);
        answer = part2 + part1;

        System.out.println("The unencrypted String is: " + answer);
    }
    // Citation Manager Method
    public void citationManager() {

        String firstname;
        String lastname;
        String book;
        String publisher;
        String city;
        int year;

        input.nextLine();
        System.out.println("Welcome to the Citation Manager!");
        System.out.println("Enter Author First Name:");
        firstname = input.nextLine();
        System.out.println("Enter Author Last Name:");
        lastname = input.nextLine();
        System.out.println("Enter Book Title:");
        book = input.nextLine();
        System.out.println("Enter Publisher:");
        publisher = input.nextLine();
        System.out.println("Enter Publisher City:");
        city = input.nextLine();
        System.out.println("Enter Publishing Year:");
        year = input.nextInt();
        System.out.printf("MLA: %s, %s. %s. %s, %d.\n", lastname,
                firstname, book, publisher, year);
        System.out.printf("APA: %s, %c. (%d). %s. %s: %s.\n", lastname,
                firstname.charAt(0), year, book, city, publisher);
    }
    // Subscription manager Method
    public void subcription() {

        int length;
        int institution;
        int signup;

        int price = 0;
        int duration = 0;
        double discount = 0;
        int price2 = 0;
        double finalprice = 0;

        input.nextLine();
        System.out.println("Welcome to the Subscription Manager!");
        System.out.println("How long do you want to subscribe?\n1. " +
                "1 Month\n2. 3 Months\n3. 6 Months\n4. 12 Months");
        length = input.nextInt();
        System.out.println("Do you have any institutional affiliations?\n1. " +
                "Purdue\n2. Federal " +
                "Government\n3. AAA\n4. Local Library\n5. none");
        institution = input.nextInt();
        System.out.println("Do you want to sign up for our live document editing " +
                "service?\n1. Yes\n2. No");
        signup = input.nextInt();

        switch(length) {
            case 1:
                price = 9;
                duration = 1;
                break;
            case 2:
                price = 18;
                duration = 3;
                break;
            case 3:
                price = 30;
                duration = 6;
                break;
            case 4:
                price = 50;
                duration = 12;
                break;
        }
        switch(institution) {
            case 1:
                discount = 0.3;
                break;
            case 2:
                discount = 0.25;
                break;
            case 3:
                discount = 0.1;
                break;
            case 4:
                discount = 0.05;
                break;
            default:
                discount = 0;
        }
        if (signup == 1) {
            price2 = 10 * duration;
        }
        finalprice = price + price2;
        finalprice = finalprice - (finalprice * discount);
        System.out.printf("Your total is: $%.2f\n", finalprice);
    }

}