package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p2_PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixTokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixTokens[0];
        int cols = matrixTokens[1];

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int numberToFind = Integer.parseInt(scan.nextLine());
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
