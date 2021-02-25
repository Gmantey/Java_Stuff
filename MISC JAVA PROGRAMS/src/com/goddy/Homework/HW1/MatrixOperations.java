package com.goddy.Homework.HW1;
/**
 * Matrix Operations
 *
 * Class can handle multiple computations with matrixes
 *
 *
 * @author Godfred Mantey, L01
 * @version Friday, February 28, 2020
 *
 */
public class MatrixOperations {
    // Main method
    public static void main(String[] args) {

    }
    // Check if the matrix have the same # of rows as columns
    public boolean sameSizeMatrix(Matrix m1, Matrix m2) {

        boolean condition =  false;
        int z = 0;
        // Check column
        if (m1.matrix.length == m2.matrix.length ) {
            for (int i = 0; i < m1.matrix.length; i++) {
                if (m1.matrix[i].length == m1.matrix.length) {
                    z += 1;
                }
            }
            if (z == m1.matrix.length) {
                condition = true;
            }
        }
        return condition;
    }

    // Adds a matrix with the same dimensions
    public Matrix addMatrix(Matrix m1, Matrix m2) {

        boolean decision = sameSizeMatrix(m1, m2);

        if (decision == false) {
            return null;
        }
        // Adds them together
        for (int i = 0; i < m2.matrix.length; i++) {
            for (int j = 0; j < m2.matrix[i].length; j++) {
                m2.matrix[i][j] += m1.matrix[i][j];
            }
        }
        return m2;
    }
    // Subtract a matrix with the same dimensions
    public Matrix subtractMatrix(Matrix m1, Matrix m2) {

        boolean decision = sameSizeMatrix(m1, m2);

        if (decision == false) {
            return null;
        }
        // Adds them together
        for (int i = 0; i < m2.matrix.length; i++) {
            for (int j = 0; j < m2.matrix[i].length; j++) {
                m1.matrix[i][j] -= m2.matrix[i][j];
            }
        }

        return m1;
    }
    // Transpose Matrix
    public Matrix transposeMatrix(Matrix m1) {

        int [][] transposed = new int [m1.matrix[0].length][m1.matrix.length];
        Matrix transpose = new Matrix(transposed);

        for (int i = 0; i < m1.matrix[0].length; i++) {
            for (int j = 0; j < m1.matrix.length; j++) {
                transposed[i][j] = m1.matrix[j][i];
            }
        }
        return transpose;
    }
    public Matrix productMatrix(Matrix m1, Matrix m2) {

        if (m1.matrix[0].length != m2.matrix.length) {
            return null;
        }
        int [][] sum = new int [m1.matrix.length][m2.matrix[0].length];
        Matrix prod = new Matrix(sum);
        System.out.println(m2.matrix[0].length);

        // Adds them together
        for (int i = 0; i < m1.matrix.length; i++) {
            for (int j = 0; j < m2.matrix[0].length; j++) {
                for (int z = 0; z < m2.matrix.length; z++) {
                    prod.matrix[i][j] = prod.matrix[i][j] + (m1.matrix[i][z] * m2.matrix[z][j]);
                }
            }
        }

        return prod;
    }
    // Prints the Matrix
    public void printMatrix(Matrix m1) {
        if (m1 == null) {
            return;
        }
        for (int i = 0; i < m1.matrix.length; i++) {
            for (int j = 0; j < m1.matrix[i].length; j++) {
                System.out.print(m1.matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

}
