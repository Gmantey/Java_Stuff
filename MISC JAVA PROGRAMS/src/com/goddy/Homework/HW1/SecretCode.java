package com.goddy.Homework.HW1;
import java.util.Scanner;
/**
 * Homework 2 -- SecretCode
 *
 * The programs prompts the user for 4 secret messages and decodes them
 * The final message is presented after all the secret messages have been decoded
 *
 * IntelliJ suggested I use the String.valueOf () method
 * while using the replaceAll method, this allows the use
 * of a character as a target.
 *
 * @author Godfred Mantey, Lab Sec 1
 * @version February 3rd, 2020
 *
 */
public class SecretCode {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Imports the Scanner class and makes an object

        // Variables
        String message1;
        String message2;
        String message3;
        String message4;

        String submessage1;
        String submessage2;
        String subSub1;
        String subSub2;

        char replace;
        int indreplace;
        int messLength;

        // Prompts the user for the first message
        System.out.println("Enter the First Secret Message:");
        message1 = input.nextLine();
        messLength = message1.length();                               // finds the length of the message

        message1 = message1.replace('x', 'e');      // replaces every x to an e
        indreplace = message1.indexOf('r');                          // finds location of 'r' character
        // creates two substrings
        submessage1 = message1.substring(0, indreplace);
        submessage2 = message1.substring(indreplace + 1, messLength);
        message1 = submessage1 + submessage2;

        messLength = message1.length();                              // finds the new length
        indreplace = message1.indexOf('$');                          // finds location of '$' character
        submessage1 = message1.substring(0, indreplace);              // creates two substrings
        submessage2 = message1.substring(indreplace + 1, messLength);

        message1 = submessage1 + submessage2;           // puts the new string together
        message1 = message1.replace('0', 'o');     // replaces ever 0 with o
        messLength = message1.length();            // finds the length of the message\

        char fifthChar = message1.charAt(4);     // finds the fifth character
        message1 = message1 + fifthChar;

        System.out.println("Enter the Second Secret Message:");
        message2 = input.nextLine();
        messLength = message2.length();          // finds the length of the message
        int endword = message2.indexOf(' ');
        // creates a substring of everything except for first word
        submessage1 = message2.substring(endword + 1, messLength);
        submessage1 = submessage1.toLowerCase();       // turns everything after first word lowercase
        // creates a substring of the first word excluding space
        submessage2 = message2.substring(0, endword + 1);
        message2 = submessage2 + submessage1;

        messLength = message2.length();           // finds the length of the first substring
        int endword2 = message2.lastIndexOf(' '); // finds last index of last space
        // creates a substring of everything after last space
        subSub1 = message2.substring(endword2 + 1, messLength);
        // creates a substring of everything before last space
        subSub2 = message2.substring(0, endword2);
        message2 = subSub2 + subSub1;                   // combines all the strings into one
        messLength = message2.length();

        message2 = message2.substring(3, messLength);      // removes the first 3 characters
        message2 = message2.replace('z', 'm');
        message2 = message2.replace('w', ' ');

        messLength = message2.length();  // finds the length of the new array
        indreplace = message2.indexOf('a');        // finds the index of the first a
        // creates a substring of everything after a char
        subSub1 = message2.substring(indreplace + 1, messLength);
        // creates a substring of everything before a char
        subSub2 = message2.substring(0, indreplace);
        message2 = subSub2 + "g" + subSub1;

        System.out.println("Enter the Third Secret Message:");
        message3 = input.nextLine();
        message3 = message3.trim();
        replace = message3.charAt(1);
        // replace every instance of asdf with 2nd character
        message3 = message3.replaceAll("asdf", String.valueOf(replace));
        messLength = message3.length();
        submessage1 = message3.substring(0, 9);
        submessage2 = message3.substring(9, messLength);

        message3 = submessage2 + submessage1;

        System.out.println("Enter the Fourth Secret Message:");
        message4 = input.nextLine();
        char first = message4.charAt(0);    // gets the first character of the message
        // gets the strings at the specified indexes
        submessage1 = message4.substring(10, 15);
        submessage2 = message4.substring(20, 25);
        subSub1 = message4.substring(30, 35);

        message4 = first + submessage1 + submessage2 + subSub1 + "!";
        System.out.printf("\nFinal message: " + message1 + message2 + message3 + message4);  // final message
    }
}
