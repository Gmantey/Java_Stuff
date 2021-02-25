/**
 * Project 3 - UnsupportedFileException
 * <p>
 * Throws an exception if a file format is incorrect
 *
 * @author Godfred Mantey, LO1
 * @version March 28, 2020
 */
package com.goddy.Project3;

public class UnsupportedFileException extends Exception {
    public UnsupportedFileException(String message) {
        super(message);
    }
}
