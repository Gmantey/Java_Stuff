package com.goddy.Homework9;

import java.text.DecimalFormat;

/**
 * Homework 9 -- Icosidodecahedron
 * <p>
 * Finds the volume and surface area using edgeLength
 * for Icosidodecahedron
 *
 * @author Godfred Mantey, LO1
 * @version March 30, 2020
 */

public class Icosidodecahedron extends ArchimedeanSolid {

    public Icosidodecahedron(double edgeLength) {
        super(edgeLength);
        if (edgeLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    // Equals Method
    public boolean equals(Object object) {

        if (object instanceof Icosidodecahedron) {
            if (((Icosidodecahedron) object).getEdgeLength() == getEdgeLength()) {
                return true;
            }
        }
        return false;
    }

    // To String Method
    public String toString() {
        DecimalFormat f = new DecimalFormat("0.000000");
        String str = "Icosidodecahedron[" + f.format(getEdgeLength()) + "]";
        return str;
    }

    @Override
    public double getVolume() {
        return ((45.0 + (17.0 * Math.sqrt(3.0))) / 6.0) * (Math.pow(getEdgeLength(), 3.0));
    }

    @Override
    public double getSurfaceArea() {
        return ((5.0 * Math.sqrt(3.0)) + (3.0 * Math.sqrt(25.0 + (10.0 * Math.sqrt(5.0))))) * Math.pow(getEdgeLength(), 2.0);
    }
}
