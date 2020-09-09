package com.company;

import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scan.nextLine());
        int commands = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            String thisLine = scan.nextLine();
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = String.valueOf(thisLine.charAt(j));
            }
        }
        int currentRow = 0;
        int currentCol = 0;
        boolean win = false;
        int[] currentPosition = findCurrentPosition(matrix);
        currentRow = currentPosition[0];
        currentCol = currentPosition[1];
        while (commands-- > 0 && win == false) {
            String cmd = scan.nextLine();
            switch (cmd) {
                case "up":
                    matrix[currentRow--][currentCol] = "-";
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                    }
                    if (matrix[currentRow][currentCol].equals("B")) {
                        //matrix[currentRow++][currentCol] = "-";
                        currentRow--;
                    }
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                    }
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentRow++;
                    }
                    if (matrix[currentRow][currentCol].equals("F")) {
                        win = true;
                        break;
                    }

                    break;
                case "down":
                    matrix[currentRow++][currentCol] = "-";
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                    }
                    if (matrix[currentRow][currentCol].equals("B")) {
                        //matrix[currentRow++][currentCol] = "-";
                        currentRow++;
                    }
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                    }
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentRow--;
                    }
                    if (matrix[currentRow][currentCol].equals("F")) {
                        win = true;
                        break;
                    }
                    break;
                case "left":
                    matrix[currentRow][currentCol--] = "-";
                    if (currentCol < 0) {
                        currentCol = matrix[currentRow].length - 1;
                    }
                    if (matrix[currentRow][currentCol].equals("B")) {
                        //matrix[currentRow++][currentCol] = "-";
                        currentCol--;
                    }
                    if (currentCol < 0) {
                        currentCol = matrix[currentRow].length - 1;
                    }
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentCol++;
                    }
                    if (matrix[currentRow][currentCol].equals("F")) {
                        win = true;
                        break;
                    }
                    break;
                case "right":
                    matrix[currentRow][currentCol++] = "-";
                    if (currentCol > matrix[currentRow].length - 1) {
                        currentCol = 0;
                    }
                    if (matrix[currentRow][currentCol].equals("B")) {
                        //matrix[currentRow++][currentCol] = "-";
                        currentCol++;
                    }
                    if (currentCol > matrix[currentRow].length - 1) {
                        currentCol = 0;
                    }
                    if (matrix[currentRow][currentCol].equals("T")) {
                        currentCol--;
                    }
                    if (matrix[currentRow][currentCol].equals("F")) {
                        win = true;
                        break;
                    }
                    break;
            }

        }
        if (win) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        matrix[currentRow][currentCol] = "f";
        printMatrix(matrix);
    }

    private static int[] findCurrentPosition(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[2];
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
