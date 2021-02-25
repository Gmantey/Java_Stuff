package com.goddy.Solution_code;

/*
-	Check if 2 matrixes has the same number of rows and the same number columns
       If yes, add then add them together and print it out.

 */


import com.goddy.Homework.HW1.Matrix;

public class Matrix_Stuff {


    public static void main(String[] args) {

        int[][] matrix1 = {
                {0, 1, 1},
                {0, 1, 1},
                {0, 1, 1}
        };
        int[][] matrix2 = {
                {0, 1, 1},
                {0, 1, 1},
                {0, 1, 6}
        };
        if (sameSizeMatrix(matrix1,matrix2)){

            printMatrix(addMatrix(matrix1, matrix2)) ;
        } else {
            System.out.println("Matrix not the same size");
        }

    }

    public static boolean sameSizeMatrix(int[][] m1, int[][] m2) {

        boolean condition =  false;
        int z = 0;
        // Check column
        if (m1.length == m2.length ) { // Rows of the Matrix
            for (int i = 0; i < m1.length; i++) {
                if (m1[i].length == m2[i].length) {
                    z += 1;
                }
            }
            if (z == m1.length) {
                condition = true;
            }
        }
        return condition;
    }
    // Adds a matrix with the same dimensions
    public static int[][] addMatrix(int[][] m1, int[][] m2) {

        boolean decision = sameSizeMatrix(m1, m2);

        if (decision == false) {
            return null;
        }
        // Adds them together
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] += m1[i][j];
            }
        }
        return m2;
    }

    // Prints the Matrix
    public static void printMatrix(int[][] m1) {
        if (m1 == null) {
            return;
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.print("\n");
        }

    }


}


