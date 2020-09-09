package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p13_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //reading the input
        String[] inputTokens = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputTokens[0]);
        int cols = Integer.parseInt(inputTokens[1]);

        String[][] matrix = new String[rows][cols];

        //filling the matrix with the input data
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("\\s+");


        }


        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            if ("swap".equals(cmd)) {
                int rowFirst = Integer.parseInt(tokens[1]);
                int colFirst = Integer.parseInt(tokens[2]);
                int rowSecond = Integer.parseInt(tokens[3]);
                int colSecond = Integer.parseInt(tokens[4]);

                boolean isValid = ifIndexIsValid(rowFirst, colFirst, rowSecond, colSecond, rows, cols);
                if (!isValid) {
                    System.out.println("Invalid input!");
                } else {
                    String current = matrix[rowFirst][colFirst];
                    matrix[rowFirst][colFirst] = matrix[rowSecond][colSecond];
                    matrix[rowSecond][colSecond] = current;
                    printMatrix(matrix, rows, cols);
                }
            } else {
                System.out.println("Invalid input!");
            }

            input = scan.nextLine();
        }



    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean ifIndexIsValid(int rowFirst, int colFirst, int rowSecond, int colSecond, int rows, int cols) {
//        if (rowFirst > rows - 1 || rowSecond > rows - 1 || colFirst > cols - 1 || colSecond > cols - 1) {
//            return false;
//        }
//        return true;
        if (rowFirst < 0 || rowFirst > rows || colFirst < 0 || colFirst > cols || rowSecond < 0 || rowSecond > rows || colSecond < 0 || colSecond > cols) {
            return  false;
        }
        return  true;
    }

}
