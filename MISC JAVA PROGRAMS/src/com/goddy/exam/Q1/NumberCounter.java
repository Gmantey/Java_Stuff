import java.util.Scanner;
/**
 * NumberCounter: Complete the main method. 
 */ 
public class NumberCounter {
    /**
     * This program prints the number of digits present in the given String.
     *
     * The String may contain numbers, letters, special characters or spaces.
     *
     * If the String is null or empty, print -1. 
     *
     * Accept the input String s via Scanner. 
     *
     */
    public static void main(String[] args) {
        int count; // Update with the result of your calculation.
        count  = 0;

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        if (s.length() == 0){
            System.out.println("-1");
        } else {

            for (int i = 0; i < s.length(); i++) {

                if (Character.isDigit(s.charAt(i))) {
                    count++;
                }
            }
        }
        // Do not modify above
        
        // Implement your solution here. 
        
        // Do not modify below
        System.out.println(count); 
    }

}
