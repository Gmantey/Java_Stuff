package com.goddy.Homework9;
import java.text.DecimalFormat;

/**
 * Homework 9 -- Cuboctahedron
 * <p>
 * Finds the volume and surface area using edgeLength
 * for Cuboctahedron
 *
 * @author Godfred Mantey, LO1
 * @version March 30, 2020
 */
public class Cuboctahedron extends ArchimedeanSolid {
    public Cuboctahedron(double edgeLength) {
        super(edgeLength);

        if (edgeLength < 0) {
            throw new IllegalArgumentException();
        }
    }
    // Equals Method
    public boolean equals(Object object) {

        if (object instanceof Cuboctahedron) {
            if (((Cuboctahedron) object).getEdgeLength() == getEdgeLength()) {
                return true;
            }
        }
        return false;
    }
    // To String Method
    public String toString() {
        DecimalFormat f = new DecimalFormat("0.000000");
        String str = "Cuboctahedron[" + f.format(getEdgeLength()) + "]";
        return str;
    }
    @Override
    public double getVolume() {
        return (5.0 / 3.0) * Math.sqrt(2.0) * Math.pow(getEdgeLength(), 3.0);
    }

    @Override
    public double getSurfaceArea() {
        return (6.0 + (2.0 * Math.sqrt(3.0))) * Math.pow(getEdgeLength(), 2.0);
    }


}
