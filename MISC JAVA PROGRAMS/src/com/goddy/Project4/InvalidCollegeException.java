package com.goddy.Project4;
/**
 * Project 4 - InvalidCollegeException
 * <p>
 * An exception class used to verify if a college input is valid
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class InvalidCollegeException extends Exception {
    public InvalidCollegeException() {
    }
    public InvalidCollegeException(String message) {
        super(message);
    }
}
