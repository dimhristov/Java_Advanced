package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p7_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = readMatrix(n, scan);

        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchingRow = tokens[0];
        int searchingCol = tokens[1];

        int[][] resultMatrix = new int[n][matrix[0].length];
        int wrongValue = matrix[searchingRow][searchingCol];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != wrongValue) {
                    resultMatrix[row][col] = matrix[row][col];
                } else {
                    int sum = 0;
                    if (col > 0 && col < matrix[row].length - 1 && row > 0 && row < (n - 1)) {
                        sum = matrix[row - 1][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row][col - 1];
                        resultMatrix[row][col] = sum;
                    } else if (col == 0 && row == 0) {
                        sum = matrix[row][col + 1] + matrix[row + 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col == matrix[row].length && row == 0) {
                        sum = matrix[row][col - 1] + matrix[row + 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col == 0 && row < n - 1) {                    //to check for n-1
                        sum = matrix[row][col + 1] + matrix[row + 1][col] + matrix[row - 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col == 0 && row == (n - 1)) {
                        sum = matrix[row - 1][col] + matrix[row][col + 1];
                        resultMatrix[row][col] = sum;
                    } else if (col == matrix[0].length - 1 && row == 0) {
                        sum = matrix[row][col - 1] + matrix[row + 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col == matrix[0].length - 1 && row > 0 && row < (n - 1)) {
                        sum = matrix[row][col - 1] + matrix[row + 1][col] + matrix[row - 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col == matrix[0].length - 1 && row == (n - 1)) {
                        sum = matrix[row][col - 1] + matrix[row - 1][col];
                        resultMatrix[row][col] = sum;
                    } else if (col > 0 && col < matrix[row].length - 1 && row == 0) {
                        sum = matrix[row +1][col] + matrix[row][col + 1] + matrix[row][col - 1];
                        resultMatrix[row][col] = sum;
                    }
                }
            }
        }
        printMatrix(resultMatrix, n, matrix[0].length);
    }

    private static void printMatrix(int[][] resultMatrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int n, Scanner scan) {
        int[][] matrix = new int[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}

