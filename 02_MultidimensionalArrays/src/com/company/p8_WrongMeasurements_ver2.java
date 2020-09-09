package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p8_WrongMeasurements_ver2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = readMatrix(n, scan);

        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchingRow = tokens[0];
        int searchingCol = tokens[1];

        int[][] resultMatrix = new int[n][matrix[0].length];
        int wrongValue = matrix[searchingRow][searchingCol];

        int sum = Integer.MIN_VALUE;
        int length = matrix[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < length; col++) {
                if (row > 0 && col > 0 && row < n - 1 && col < length - 1) {

                    int l = matrix[row][col - 1];
                    int r = matrix[row][col + 1];
                    int u = matrix[row - 1][col];
                    int d = matrix[row + 1][col];

                    sum += l + r + u + d;
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


