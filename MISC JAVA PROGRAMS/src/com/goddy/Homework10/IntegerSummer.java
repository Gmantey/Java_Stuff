package com.goddy.Homework10;

/**
 * Homework 11 -- IntegerSummer
 * <p>
 * Sums integers in an interval that can be spawned as a thread
 *
 * @author Godfred Mantey, L01
 * @version April, 3 2020
 */
public class IntegerSummer implements Runnable {
    private static int counter = 0;
    public int start;
    public int end;

    /**
     * @param start The start of the interval.
     * @param end   The end of the interval.
     */
    public IntegerSummer(int start, int end) {

        this.end = end;
        this.start = start;
    }

    public void run() {

        for (int i = start; i < end; i++) {
            counter += i;
        }
    }

    /**
     * @return The counter variable.
     */
    public static int getCounter() {
        return counter;
    }

    // Getters and Setters
    public int getStart() {
        return start;
    }
}
