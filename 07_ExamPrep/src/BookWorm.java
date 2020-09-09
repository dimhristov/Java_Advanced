import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class BookWorm {
    private static int currentRow;
    private static int currentCol;
    private static ArrayList<String> wordAsList;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        wordAsList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordAsList.add(String.valueOf(word.charAt(i)));
        }


        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][size];

        readMatrix(scan, matrix);
        findCurrentPosition(matrix);
        matrix[currentRow][currentCol] = "-";
        String cmd = scan.nextLine();

        while (!cmd.equals("end")) {
            switch (cmd) {
                case"up":moveUp(matrix);break;
                case"down": moveDown(matrix);break;
                case"left":moveLeft(matrix);break;
                case"right":moveRight(matrix);break;
            }


            cmd = scan.nextLine();
        }
        for (String s : wordAsList) {
            System.out.print(s);
        }
        System.out.println();
        matrix[currentRow][currentCol] = "P";
        printMatrix(matrix);
    }

    private static void moveRight(String[][] matrix) {
        currentCol++;
        if (currentCol >matrix.length-1) {
            if (!wordAsList.isEmpty()) {
                wordAsList.remove(wordAsList.size()-1);
                currentCol--;
                return;
            }
        }
        if (!matrix[currentRow][currentCol].equals("-") ) {
            String letter = matrix[currentRow][currentCol];
            wordAsList.add(letter);
            matrix[currentRow][currentCol] = "-";
        }

    }

    private static void moveLeft(String[][] matrix) {
        currentCol--;
        if (currentCol < 0) {
            if (!wordAsList.isEmpty()) {
                wordAsList.remove(wordAsList.size() - 1);
                currentCol++;
                return;
            }
        }
        if (!matrix[currentRow][currentCol].equals("-")) {
            String letter = matrix[currentRow][currentCol];
            wordAsList.add(letter);
            matrix[currentRow][currentCol] = "-";
        }

    }

    private static void moveDown(String[][] matrix) {
        currentRow++;
        if (currentRow >matrix.length-1) {
            if (!wordAsList.isEmpty()) {
                wordAsList.remove(wordAsList.size()-1);
                currentRow--;
                return;
            }
        }
        if (!matrix[currentRow][currentCol].equals("-")) {
            String letter = matrix[currentRow][currentCol];
            wordAsList.add(letter);
            matrix[currentRow][currentCol] = "-";
        }
    }

    private static void moveUp(String[][] matrix) {
        currentRow--;
        if (currentRow < 0 ) {
            if (!wordAsList.isEmpty()) {
                wordAsList.remove(wordAsList.size() - 1);
                currentRow++;
                return;
            }
        }
        if (!matrix[currentRow][currentCol].equals("-") ) {
            String letter = matrix[currentRow][currentCol];
            wordAsList.add(letter);
            matrix[currentRow][currentCol] = "-";
        }
    }

    private static void readMatrix(Scanner scan, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int col = 0; col < matrix[i].length; col++) {
                matrix[i][col] = String.valueOf(line.charAt(col));

            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findCurrentPosition(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    currentRow = row;
                    currentCol =col;
                    return;
                }
            }
        }
    }
}
