package com.goddy.Labs;

import java.util.Scanner;

public class PersonalizedGreeting {
     public static void main(String[] args) {

         Scanner scan = new Scanner (System.in);
         System.out.println("Please enter your name");
         String name = scan.nextLine();
         System.out.println("Hello, "+ name + ". Welcome to CS!");


    }
}
