package com.goddy.Project4;
/**
 * Project 4 - InvalidStudentException
 * <p>
 * An exception class used to verify if a student input is valid
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class InvalidStudentException extends Exception {
    public InvalidStudentException() {
    }
    public InvalidStudentException(String message) {
        super(message);
    }
}
