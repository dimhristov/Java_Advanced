package com.company;

import java.util.Scanner;

public class p10_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];


        matrix = fillMatrix(rows, cols);
        printMatrix(matrix,rows,cols);

    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        int asciiNum = 97;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + (char) (97 + row) + (char) (asciiNum + col) + (char) (97 + row);
            }
            asciiNum++;
        }

        return matrix;
    }
}
