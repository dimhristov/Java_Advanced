package com.company;

import java.util.Scanner;

public class p6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scan.nextLine());

        String[][] matrix = readMatrix(rowsAndCols, scan);
        for (int row = 0; row < rowsAndCols; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        int col = 0;
        for (int row = rowsAndCols-1; row >=0; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
        int a = 0;
    }

    private static String[][] readMatrix(int rowsAndCols, Scanner scan) {
        String[][] matrix = new String[rowsAndCols][];
        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
