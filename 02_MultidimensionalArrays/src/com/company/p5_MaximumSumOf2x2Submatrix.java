package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixTokens = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixTokens[0];
        int cols = matrixTokens[1];

        int[][] matrix = readMatrix(rows,cols,scan);

        int sum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if (currentSum > sum) {
                    sum = currentSum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1] + System.lineSeparator() + matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println(sum);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
            return matrix;
    }
}
