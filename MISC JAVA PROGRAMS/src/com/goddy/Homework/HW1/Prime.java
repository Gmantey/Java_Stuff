package com.goddy.Homework.HW1;
import java.util.Scanner;
/**
 * Homework 4 -- Prime
 *
 * This program collects an integer N and find a prime number where
 * the sum of all the preceding prime numbers are less than or equal to
 * the number N
 *
 * @author Godfred Mantey, L01
 * @version Monday, February 17, 2020
 *
 */
public class Prime {
    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        int number;
        int sumcount = 0;
        boolean check;
        int[] primenumbers = new int[50847534];
        int arrcount = 0;

        do {
            System.out.println("Enter number N:");
            number = scan.nextInt();
            if (number == -1) {
                System.out.printf("Terminating program...\nBye!\n");
            } else if (number < 2) {
                System.out.println("N Should not be less than 2");
            } else if (number > 1e9) {
                System.out.println("N Should not be bigger than 1e9");
            }
            if (number < 1e9 && number > 10) {
                if (number % 2 == 1) {
                    number = number + 1;
                }
                for (int i = number; i > 2; i--) {
                    check = false;
                    int j = 2;
                    System.out.println(j);
                    System.out.println(i);
                    while (j <= (number / 2)) {
                        if (i % j == 0) {
                            check = true;
                            break;
                        }
                        j++;
                    }
                    if (!check) {
                        primenumbers[arrcount] = i;
                        System.out.println( i + " is a prime number");
                        arrcount++;
                    }
                }
                int z = (arrcount - 1);
                sumcount = 5;
                while (z > 0 && (sumcount <= number)) {
                    sumcount += primenumbers[z];
                    z--;
                }
                if (sumcount > number ) {
                    sumcount = primenumbers[z + 2];
                }
                System.out.printf("The last valid prime number is: %d\n", sumcount);

            } else if (number <= 10 && number >= 2) {
                switch (number) {
                    case 2:
                    case 3:
                    case 4:
                        sumcount = 2;
                        System.out.printf("The last valid prime number is: %d\n", sumcount);
                        break;
                    case 10:
                        sumcount = 5;
                        System.out.printf("The last valid prime number is: %d\n", sumcount);
                        break;
                    default:
                        sumcount = 3;
                        System.out.printf("The last valid prime number is: %d\n", sumcount);
                }
            }

        } while (number != -1);
    }
}