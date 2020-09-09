package Exam2020;

import java.util.Scanner;

public class Snake {
    private static int snakeHeadRow;
    private static int snakeHeadCol;
    private static int foodQuantity;
    private static boolean wentOutOfBorder = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        findSnakeCoordinates(matrix);

        while (!wentOutOfBorder && foodQuantity < 10) {
            String cmd = scan.nextLine();
            switch (cmd) {
                case "up": moveUp(matrix); break;
                case "down":moveDown(matrix);break;
                case "left":moveLeft(matrix);break;
                case "right":moveRight(matrix);break;
            }
        }
        if (wentOutOfBorder) {
            System.out.println("Game over!");
            System.out.println(String.format("Food eaten: %d",foodQuantity));
        }
        if (foodQuantity >= 10) {
            System.out.println("You won! You fed the snake.");
            System.out.println(String.format("Food eaten: %d",foodQuantity));
        }
        printMatrix(matrix);

    }

    private static void moveRight(char[][] matrix) {
        matrix[snakeHeadRow][snakeHeadCol] = '.';
        snakeHeadCol++;
        if (snakeHeadCol > matrix[snakeHeadRow].length - 1) {
            wentOutOfBorder = true;
            return;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == '*') {
            foodQuantity++;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == 'B') {
            matrix[snakeHeadRow][snakeHeadCol] = '.';
            int[] bulkCoordinates = findCoordinatesOfBulk(matrix);
            snakeHeadRow = bulkCoordinates[0];
            snakeHeadCol = bulkCoordinates[1];
        }
        matrix[snakeHeadRow][snakeHeadCol] = 'S';
    }

    private static void moveLeft(char[][] matrix) {
        matrix[snakeHeadRow][snakeHeadCol] = '.';
        snakeHeadCol--;
        if (snakeHeadCol < 0) {
            wentOutOfBorder = true;
            return;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == '*') {
            foodQuantity++;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == 'B') {
            matrix[snakeHeadRow][snakeHeadCol] = '.';
            int[] bulkCoordinates = findCoordinatesOfBulk(matrix);
            snakeHeadRow = bulkCoordinates[0];
            snakeHeadCol = bulkCoordinates[1];
        }
        matrix[snakeHeadRow][snakeHeadCol] = 'S';
    }

    private static void moveDown(char[][] matrix) {
        matrix[snakeHeadRow][snakeHeadCol] = '.';
        snakeHeadRow++;
        if (snakeHeadRow > matrix.length-1) {
            wentOutOfBorder = true;
            return;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == '*') {
            foodQuantity++;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == 'B') {
            matrix[snakeHeadRow][snakeHeadCol] = '.';
            int[] bulkCoordinates = findCoordinatesOfBulk(matrix);
            snakeHeadRow = bulkCoordinates[0];
            snakeHeadCol = bulkCoordinates[1];
        }
        matrix[snakeHeadRow][snakeHeadCol] = 'S';
    }

    private static void moveUp(char[][] matrix) {
        matrix[snakeHeadRow][snakeHeadCol] = '.';
        snakeHeadRow--;
        if (snakeHeadRow < 0) {
            wentOutOfBorder = true;
            return;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == '*') {
            foodQuantity++;
        }
        if (matrix[snakeHeadRow][snakeHeadCol] == 'B') {
            matrix[snakeHeadRow][snakeHeadCol] = '.';
            int[] bulkCoordinates = findCoordinatesOfBulk(matrix);
            snakeHeadRow = bulkCoordinates[0];
            snakeHeadCol = bulkCoordinates[1];
        }
        matrix[snakeHeadRow][snakeHeadCol] = 'S';
    }

    private static int[] findCoordinatesOfBulk(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    return coordinates;
                }
            }
        }
        return null;
    }

    private static void findSnakeCoordinates(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    snakeHeadRow = row;
                    snakeHeadCol = col;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
