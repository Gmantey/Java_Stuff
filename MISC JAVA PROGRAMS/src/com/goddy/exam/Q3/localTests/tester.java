import java.util.Scanner;

public class tester {
    
    
    public static void main(String [] args) {

	OddOrEven number = new OddOrEven(); 
	
	int num1 = Integer.parseInt(args[0]) ;  
	int num2 = Integer.parseInt(args[1]) ; 

	System.out.println(number.isEven(num1, num2));

	}
}
