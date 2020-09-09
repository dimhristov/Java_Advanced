package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String firstMatrix[][] = readMatrix(rows, cols, scan);
        String secondMatrix[][] = readMatrix(rows, cols, scan);
        String thirdMatrix[][] = new String[rows][cols];

        //comparing both matrices
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else {
                    thirdMatrix[row][col] = "*";
                }
            }
        }
        printMatrix(thirdMatrix,rows,cols);

    }

    private static void printMatrix(String[][] thirdMatrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(thirdMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

}
