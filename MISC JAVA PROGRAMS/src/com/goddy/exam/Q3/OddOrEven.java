/**
 * Write your code for OddOrEven in an isEven() method below.
 */
public class OddOrEven {
    /**
     * Determines if the sum of two integers is odd or even. 
     *
     *
     * Sample usage:
     *  - isEven(10, 2) //returns true
     *  - isEven(99, 2) //returns false
     *  - isEven(7, 5) //returns false
     *  - isEven(11, 0) //returns false
     *  - isEven(100, 50) //returns true     
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return true if the sum is even, false if the sum is odd
     *
     * Create a method called isEven() that accepts the parameters described above 
     * in the order they are listed.
     */
    
    // Do not modify above
    
    // Implement your solution here

    public boolean isEven (int num1 , int num2){

        int sum = num1 + num2;
        sum = (sum % 2);
        if (sum % 2 == 1){
            return false;
        }
        return true;
    }

    
    // Do not modify below

}
