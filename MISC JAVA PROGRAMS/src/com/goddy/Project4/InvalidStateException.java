package com.goddy.Project4;
/**
 * Project 4 - InvalidStateException
 * <p>
 * An exception class used to verify if a state input is valid
 *
 * @author Godfred Mantey, LO1
 * @version April 11, 2020
 */
public class InvalidStateException extends Exception {
    public InvalidStateException() {
    }
    public InvalidStateException(String message) {
        super(message);
    }
}
