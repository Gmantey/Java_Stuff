import java.util.Scanner;
/**
 * Triangle: Complete the main method. 
 */
public class Triangle {
    /**
     * Print a triangle with a base of n in the following format: 
	 * "****"
	 * " ***"
	 * "  **"
	 * "   *"
     *
     * In the above example, the base is 4. 
     *
     * Accept the input int n via Scanner. 
     * 
     * NOTE:
     *      - The quotes ("") are only included to illustrate the bounds of the triangle, do not print them. 
     *      - You must print spaces (" ") to align the triangle properly. 
	 *
     *
     */
    public static void main(String[] args) {
		// Do not modify above
		Scanner input = new Scanner(System.in);
		int base;
		base = input.nextInt();

		for (int i = base; i > 0; i--){
			for (int j = i ; j > 0; j--){
				System.out.printf("*");
			}
			System.out.printf("\n");
			int x =  base - i;

			for(int y = 0; y <= x; y++){
				System.out.printf(" ");
			}
		}

        // Implement your solution here
        
        // Do not modify below

    }

}
