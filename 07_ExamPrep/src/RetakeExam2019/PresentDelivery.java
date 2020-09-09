package RetakeExam2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int presents = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = readMatrix(n, scan);
        int[] santaPosition = findSantaPosition(matrix);

        String cmd = scan.nextLine();
        int currentRow = santaPosition[0];
        int currentCol = santaPosition[1];
        matrix[currentRow][currentCol] = "-";
        int happyKidsCounter = 0;
        while (!cmd.equals("Christmas morning") || presents ==0) {
            switch (cmd) {
                case "up":
                    currentRow--;
                    if (matrix[currentRow][currentCol].equals("X")) {
                        matrix[currentRow][currentCol] = "-";
                    }
                    if (matrix[currentRow][currentCol].equals("V")) {
                        presents--;
                        matrix[currentRow][currentCol] = "-";
                        happyKidsCounter++;
                    }
                    if (matrix[currentRow][currentCol].equals("C")) {
                        //up
                        try {
                            matrix[currentRow - 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //down
                        try {
                            matrix[currentRow + 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //left
                        try {
                            matrix[currentRow ][currentCol-1] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //right\
                        try {
                            matrix[currentRow ][currentCol+1 ] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                    }
                    break;
                case "down":
                    currentRow++;
                    if (matrix[currentRow][currentCol].equals("X")) {
                        matrix[currentRow][currentCol] = "-";
                    }
                    if (matrix[currentRow][currentCol].equals("V")) {
                        presents--;
                        matrix[currentRow][currentCol] = "-";
                        happyKidsCounter++;
                    }
                    if (matrix[currentRow][currentCol].equals("C")) {
                        //up
                        try {
                            matrix[currentRow - 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //down
                        try {
                            matrix[currentRow + 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //left
                        try {
                            matrix[currentRow ][currentCol-1] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //right\
                        try {
                            matrix[currentRow ][currentCol+1 ] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                    }
                    break;
                case "right":
                    currentCol++;
                    if (matrix[currentRow][currentCol].equals("X")) {
                        matrix[currentRow][currentCol] = "-";
                    }
                    if (matrix[currentRow][currentCol].equals("V")) {
                        presents--;
                        matrix[currentRow][currentCol] = "-";
                        happyKidsCounter++;
                    }
                    if (matrix[currentRow][currentCol].equals("C")) {
                        //up
                        try {
                            matrix[currentRow - 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //down
                        try {
                            matrix[currentRow + 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //left
                        try {
                            matrix[currentRow ][currentCol-1] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //right\
                        try {
                            matrix[currentRow ][currentCol+1 ] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                    }
                    break;
                case "left":
                    currentCol--;
                    if (matrix[currentRow][currentCol].equals("X")) {
                        matrix[currentRow][currentCol] = "-";
                    }
                    if (matrix[currentRow][currentCol].equals("V")) {
                        presents--;
                        matrix[currentRow][currentCol] = "-";
                        happyKidsCounter++;
                    }
                    if (matrix[currentRow][currentCol].equals("C")) {
                        //up
                        try {
                            matrix[currentRow - 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //down
                        try {
                            matrix[currentRow + 1][currentCol] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //left
                        try {
                            matrix[currentRow ][currentCol-1] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                        //right\
                        try {
                            matrix[currentRow ][currentCol+1 ] = "-";
                            presents--;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Index out of bounds");
                        }
                    }
                    break;
            }


            cmd = scan.nextLine();
        }
        matrix[currentRow][currentCol] = "S";
        printMatrix(matrix);


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveSanta(String[][] matrix, String up, int[] santaPosition) {

    }

    private static int[] findSantaPosition(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static String[][] readMatrix(int cols, Scanner scan) {
        int rows = cols;
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scan.next();
            }
            if (row != rows - 1) {
                scan.nextLine();
            }
        }
        return matrix;
    }


}
