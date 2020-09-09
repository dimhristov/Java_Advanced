package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p12_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[i][col] = arr[col];
            }
        }
        int sum = findTheBiggestSquareSum(matrix, rows, cols);
        System.out.printf("Sum = %d", sum);
        System.out.println();
        printSquareMatrix(matrix,rows,cols);
    }

    private static int findTheBiggestSquareSum(int[][] matrix, int rows, int cols) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col] +
                        matrix[row][col + 1] + matrix[row + 1][col + 1] + matrix[row + 2][col + 1] +
                        matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];

                if (currentSum > sum) {
                    sum = currentSum;
                }
            }
        }
        return sum;
    }
    private static void printSquareMatrix(int[][] matrix, int rows, int cols) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;
        Map<Integer,String> startIndexSquareMatrix = new HashMap<>();
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col] +
                        matrix[row][col + 1] + matrix[row + 1][col + 1] + matrix[row + 2][col + 1] +
                        matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];
                startIndexSquareMatrix.put(currentSum,("" + row + " " + col));
                if (currentSum > sum) {
                    sum = currentSum;
                }
            }
        }
        int[][] squareMatrix = new int[3][3];
        int[] startIndex = Arrays.stream(startIndexSquareMatrix.get(sum).split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = startIndex[0];
        int startCol = startIndex[1];

        int r = 0;
        int c = 0;
        for (int row = startRow; row < startRow+3; row++) {
            for (int col = startCol; col < startCol+3; col++) {
                squareMatrix[r][c] = matrix[row][col];
                c++;
            }
            r++;
            c =0;
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(squareMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }


}
