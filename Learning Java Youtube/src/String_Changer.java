import java.util.Scanner;
/*
-	Create a class that will take a string, replace all x’s with an e
    * find the location of the letter r.
	* Turns everything after the first word string to lowercase
	* And removes the last 3 characters.
	* Find new length of string
 */
public class String_Changer {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String message = in.nextLine();

        // Replace all x with an e
        message = message.replaceAll("x","e");

        // find the location of the letter r
        int location = message.indexOf('r');

        // Turn everything after the first word to lowercase
        int space = message.indexOf(' ');
        String first;
        String second;

        first = message.substring(0,space);
        second = message.substring(space + 1);

        // Turn second word to lowercase
        second = second.toLowerCase();

        message = first + " " + second;

        // remove last three characters
        message = message.substring(0, message.length() - 3);

        // find the length of the string
        int len = message.length();

        System.out.println("Your new word is: " + message);
        System.out.println("The length of the string is now: "+ len);




    }

}
