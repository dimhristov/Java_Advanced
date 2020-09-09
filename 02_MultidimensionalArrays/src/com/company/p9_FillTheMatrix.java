package com.company;

import java.util.Scanner;

public class p9_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[n][n];


        matrix = fillMatrix(n, pattern);
        printMatrix(matrix,n);


    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int n, String pattern) {
        int[][] matrix = new int[n][n];
        int filler = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = filler;
                    filler++;
                }
            }
        } else if (pattern.equals("B")) {
            int oddNum = 1;
            for (int col = 0; col < n; col++) {
                if (oddNum % 2 != 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = filler;
                        filler++;
                    }
                    oddNum++;
                } else if (oddNum % 2 == 0) {
                    for (int row = n-1; row >=0 ; row--) {
                        matrix[row][col] = filler;
                        filler++;
                    }
                    oddNum++;
                }
            }

        }

        return matrix;
    }
}
