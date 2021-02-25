package com.goddy.Homework.HW1;
/**
 * Homework 5 --- Calculator
 *
 *  A program that performs simple calculations and keeps
 *  track of the previous answer and the amount of computations
 *  it has done
 *
 *
 * @author Godfred Mantey, LO1
 * @version February 19, 2020
 *
 */

public class Calculator {
    // Fields
    private double prevResult;
    private int count;

    // Constructor
    public Calculator() {
        this.count =  count;
        this.prevResult = prevResult;
    }

    public static void main(String[] args) {
        // Main method
    }

    // Add method
    public int add(int a, int b) {
        this.prevResult = a + b;
        this.count++;
        return  (int)this.prevResult;
    }
    // Subtract method
    public int subtract(int a, int b) {
        this.prevResult = a - b;
        this.count++;
        return (int)this.prevResult;
    }
    // multiply method
    public int multiply(int a, int b) {
        this.prevResult = a * b;
        this.count++;
        return (int)this.prevResult;
    }
    // divide method
    public double divide(int a, int b) {
        this.prevResult = (double)a / b;
        this.count++;
        return prevResult;
    }

    // Calculate Circle Area method
    public double calculateCircleArea(int r) {
        this.prevResult = Math.PI * Math.pow((double)r, 2.0);
        this.count++;
        return prevResult;
    }
    // Calculate  Power Method
    public int calculatePower(int a, int x) {
        prevResult = Math.pow((double)a, (double)x);
        this.count++;
        return (int)prevResult;
    }

    // update count method  -->Probably not needed tbh
    public void updateCount() {
        this.count++;
    }

    //$$$$ Getters and Setters $$$$//

    // Getter for Prevresult
    public double getPrevResult() {
        return this.prevResult;
    }
    // Setter for Prevresult
    public void setPrevResult(double result) {
        this.prevResult =  result;
    }
    // Getter for Count
    public int getCount() {
        return this.count;
    }
    // Setter for PrevResult
    public void setCount(int count) {
        this.count =  count;
    }

}


