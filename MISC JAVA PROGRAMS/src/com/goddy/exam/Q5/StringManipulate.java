import java.util.Scanner;
/**
 * StringManipulate: Complete the main method. 
 */ 
public class StringManipulate {
    /**
     * Groups the characters in the specified String in the order they appear in, and prints the new String.
     *
     * Special Cases:
     *      - If the given String is null or empty, print -1.
     *
	 * Accept the input String s via Scanner. 
	 *
     * Examples
     * 
     *   Input:        null
     *   Print value:  -1
     *
     *   Input:        ""
     *   Print value:  -1 
     *
     *   Input:        "bacddacbd"
     *   Print value:  "bbaaccddd"
     *
     *   Input:        "^% ##dt()&^(#)%("
     *   Print value:  "^^%% ###dt((())&"
     *
     */
    public static void main(String[] args) {

        String result; // Update with the result of processing word.
		
        // Do not modify above
        result = "";
        Scanner s =  new Scanner(System.in);
        String input = s.nextLine();

        char x = (char)((int)input.charAt(0) + 1); // makes it something completely different so it can do it the first time

        for (int i = 0; i < input.length(); i++) {

            if (Character.valueOf(input.charAt(i)) == Character.valueOf(x)){
                continue;
            }else {
                for (int j = i; j < (input.length()); j++) {
                    if (Character.valueOf(input.charAt(i)) == Character.valueOf(input.charAt(j))) {
                        result += input.charAt(j);
                    }
                }
            }
            if (input.length() == result.length()){
               break;
            }
         x = result.charAt(result.length() - 1);
        }

        // Implement your solution here. Store the result in word. 
        
        // Do not modify below

        System.out.println(result);
    }
}
