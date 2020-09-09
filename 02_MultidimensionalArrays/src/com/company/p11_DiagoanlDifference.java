package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p11_DiagoanlDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int r = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[r][r];


        for (int i = 0; i < r; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < r; col++) {
                matrix[i][col] = arr[col];
            }
        }
        int primaryDiagonal = findPrimaryDiagonal(matrix, r);
        int secondaryDiagonal = findSecondaryDiagonal(matrix, r);

        int difference = Math.abs(primaryDiagonal-secondaryDiagonal);
        System.out.println(difference);


    }

    private static int findSecondaryDiagonal(int[][] matrix, int r) {
        int sum = 0;
        int col = 0;
        for (int row = r - 1; row >= 0; row--) {
            sum +=matrix[row][col];
            col++;
        }
        return sum;
    }

    private static int findPrimaryDiagonal(int[][] matrix, int r) {
        int sum = 0;
        for (int row = 0; row < r; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix, int r) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < r; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
