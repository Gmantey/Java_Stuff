package com.goddy.Solution_code;

import java.util.Scanner;

public class String_Manipulator {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // explain this

        String message = in.nextLine();
        // Replace all x with and e
        message = message.replaceAll("x","e"); // Explain that string are immutable

        // find the location of letter r (index)
        int location = message.indexOf('r');

        // turn everything after the first word to lowercase
        String first;
        String second;

        int space = message.indexOf(' ');
        first = message.substring(0,space);
        second = message.substring(space + 1);

        second = second.toLowerCase();

        message = first + " " + second;

        // remove the last 3 characters

        message = message.substring(0, message.length() - 3);

        int lengthmessage = message.length();

        System.out.println(message + " " + lengthmessage);









    }

}
