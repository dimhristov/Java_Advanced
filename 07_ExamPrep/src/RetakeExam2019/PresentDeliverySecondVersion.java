package RetakeExam2019;

import java.util.Scanner;

public class PresentDeliverySecondVersion {
    public static int finishRow;
    public static int finishCol;
    public static int currentRow;
    public static int currentCol;
    public static int countOfPresents;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         countOfPresents = Integer.parseInt(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];

        readMatrix(scan, n, matrix);
        findSantaCurrentPosition(matrix);
        String cmd = scan.nextLine();
        while (!cmd.equals("Christmas morning") && countOfPresents > 0) {
            switch (cmd) {
                case"up": moveUp(matrix); break;
                case"down": moveDown(matrix); break;
                case"left": moveLeft(matrix); break;
                case"right": moveRight(matrix) ; break;
            }
            if (countOfPresents <= 0) {
                break;
            }
            cmd = scan.nextLine();
        }

        int niceKidsLeft = checkForNiceKids(matrix);
        if (niceKidsLeft > 0) {
            System.out.println("Santa ran out of presents!");
            matrix[currentRow][currentCol] = "S";
            printMatrix(matrix);
            System.out.println(String.format("No presents for %d nice kid/s.",niceKidsLeft));
        } else {
            matrix[currentRow][currentCol] = "S";
            printMatrix(matrix);
            System.out.println(String.format("Good job, Santa! 2 happy nice kid/s.",niceKidsLeft));
        }

    }

    private static int checkForNiceKids(String[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("V")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void moveRight(String[][] matrix) {
        matrix[currentRow][currentCol] = "-";
        currentCol++;
        if (currentCol > matrix[currentRow].length) {
            currentCol = 0;
        }
        if (matrix[currentRow][currentCol].equals("X")) {

        }
        if (matrix[currentRow][currentCol].equals("V")) {
            countOfPresents--;
            matrix[currentRow][currentCol] = "-";
        }
        if (matrix[currentRow][currentCol].equals("C")) {
            spreadSomeGifts(matrix);

        }
    }

    private static void moveLeft(String[][] matrix) {
        matrix[currentRow][currentCol] = "-";
        currentCol--;
        if (currentCol < 0) {
            currentCol = matrix[currentRow].length-1;
        }
        if (matrix[currentRow][currentCol].equals("X")) {

        }
        if (matrix[currentRow][currentCol].equals("V")) {
            countOfPresents--;
            matrix[currentRow][currentCol] = "-";
        }
        if (matrix[currentRow][currentCol].equals("C")) {
            spreadSomeGifts(matrix);
        }
    }

    private static void moveDown(String[][] matrix) {
        matrix[currentRow][currentCol] = "-";
        currentRow++;
        if (currentRow > matrix.length-1) {
            currentRow = 0;
        }
        if (matrix[currentRow][currentCol].equals("X")) {

        }
        if (matrix[currentRow][currentCol].equals("V")) {
            countOfPresents--;
            matrix[currentRow][currentCol] = "-";
        }
        if (matrix[currentRow][currentCol].equals("C")) {
            spreadSomeGifts(matrix);
        }
    }

    private static void moveUp(String[][] matrix) {
        matrix[currentRow][currentCol] = "-";
        currentRow--;
        if (currentRow < 0) {
            currentRow = matrix.length-1;
        }
        if (matrix[currentRow][currentCol].equals("X")) {

        }
        if (matrix[currentRow][currentCol].equals("V")) {
            countOfPresents--;
            matrix[currentRow][currentCol] = "-";
        }
        if (matrix[currentRow][currentCol].equals("C")) {
            spreadSomeGifts(matrix);
        }
    }

    private static void spreadSomeGifts(String[][] matrix) {
        int indexRow = currentRow;
        int indexCol = currentCol;
        try {
            matrix[indexRow - 1][indexCol] = "-";
            countOfPresents--;
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }
        try {
            matrix[indexRow + 1][indexCol] = "-";
            countOfPresents--;
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }
        try {
            matrix[indexRow][indexCol- 1] = "-";
            countOfPresents--;
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }
        try {
            matrix[indexRow ][indexCol + 1] = "-";
            countOfPresents--;
        } catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }
    }

    private static void findSantaCurrentPosition(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
    }

    private static void readMatrix(Scanner scan, int n, String[][] matrix) {
        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            matrix[i] = line;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
