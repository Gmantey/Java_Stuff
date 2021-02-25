package Episode1_Problems;

/*
-	Create a class that will take a string, replace all x’s with an e
    * find the location of the letter r.
	* Turns everything after the first word string to lowercase
	* And removes the last 3 characters.
	* Find new length of string
 */

import java.util.Scanner;

public class String_Manipulator {


    public static void main(String[] args) {

        System.out.printf("Enter a sentence: ");
        Scanner in =  new Scanner(System.in);

        String message = in.nextLine();
        // replace all x with an e
        message = message.replaceAll("x", "e");
        // find the location of the letter r (index)
        int location = message.indexOf('r');
        String first;
        String second;

        int space = message.indexOf(' ');
        first = message.substring(0, space);
        second = message.substring(space + 1);
        second = second.toLowerCase();

        message = first + " " +  second;

        // remove last three characters
        message = message.substring(0, message.length() - 3);

        int len = message.length();

        System.out.println("Your new word is: " + message);
        System.out.println("The length of string is : " + len);

    }

}
