package com.goddy.Homework9;

import java.text.DecimalFormat;

/**
 * Homework 9 -- ArchimedeanSolid
 * <p>
 * An abstract class that will be extended by two other
 * classes
 *
 * @author Godfred Mantey, LO1
 * @version March 30, 2020
 */
public abstract class ArchimedeanSolid {

    // Fields
    private double edgeLength;

    // Constructor Method
    public ArchimedeanSolid(double edgeLength) {
        this.edgeLength = edgeLength;
        if (edgeLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    // Equals Method
    public boolean equals(Object object) {

        if (object instanceof ArchimedeanSolid) {
            if (((ArchimedeanSolid) object).edgeLength == this.edgeLength) {
                return true;
            }
        }
        return false;
    }

    // To String Method
    public String toString() {
        DecimalFormat f = new DecimalFormat("0.000000");
        String str = "ArchimedeanSolid[" + f.format(getEdgeLength()) + "]";
        return str;
    }

    // Abstract Methods
    public abstract double getVolume();

    public abstract double getSurfaceArea();

    // Getter and Setters
    public double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }
}
