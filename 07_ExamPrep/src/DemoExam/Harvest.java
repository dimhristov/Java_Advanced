package DemoExam;

import java.util.Scanner;

public class Harvest {
    private static int row;
    private static int col;
    private static int harmedVeggies;
    private static int carrots;
    private static int potatoes;
    private static int lettuce;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }
        String cmdInput;
        while (!(cmdInput = scan.nextLine()).equals("End of Harvest")) {
            String[] tokens = cmdInput.split(" ");
            String cmd = tokens[0];
            row = Integer.parseInt(tokens[1]);
            col = Integer.parseInt(tokens[2]);

            switch (cmd) {
                case "Harvest":
                    if (row >= 0 && row < matrix.length) {
                        if (col >= 0 && col < matrix[row].length) {
                            coutVeggies(matrix,row,col);
                            matrix[row][col] = " ";
                        }
                    }
                    break;
                case "Mole":
                    String direction = tokens[3];
                    switch (direction) {
                        case "up": moveUp(matrix,row,col); break;
                        case "down": moveDown(matrix,row,col); break;
                        case "left": moveLeft(matrix,row,col); break;
                        case "right":moveRight(matrix,row,col); break;
                    }
                    break;
            }

        }
        printMatrix(matrix);
        System.out.println(String.format("Carrots: %d",carrots));
        System.out.println(String.format("Potatoes: %d",potatoes));
        System.out.println(String.format("Lettuce: %d",lettuce));
        System.out.println(String.format("Harmed vegetables: %d",harmedVeggies));

    }

    private static void coutVeggies(String[][] matrix, int row, int col) {
        if (matrix[row][col].equals("L")) {
            lettuce++;
        } else if (matrix[row][col].equals("P")) {
            potatoes++;
        } else if (matrix[row][col].equals("C")) {
            carrots++;
        }
    }

    private static void moveRight(String[][] matrix, int row, int col) {
        if (col < matrix[row].length && col >=0) {
            if (col % 2 == 0) {
                for (int currentCol = col; currentCol < matrix[row].length; currentCol += 2) {
                    countHarvestVegetables(matrix, row, currentCol);
                    matrix[row][currentCol] = " ";
                }
            } else {
                for (int currentCol = col; currentCol < matrix[row].length; currentCol += 2) {
                    countHarvestVegetables(matrix, row, currentCol);
                    matrix[row][currentCol] = " ";
                }
            }
        }
    }

    private static void countHarvestVegetables(String[][] matrix, int row, int col) {
        if (!matrix[row][col].equals(" ")) {
            harmedVeggies++;
        }

    }

    private static void moveLeft(String[][] matrix, int row, int col) {
        if (col < matrix[row].length && col >=0) {
            if (col % 2 == 0) {
                for (int currentCol = col; currentCol >= 0; currentCol -= 2) {
                    countHarvestVegetables(matrix, row, currentCol);
                    matrix[row][currentCol] = " ";
                }
            } else {
                for (int currentCol = col; currentCol >= 1; currentCol -= 2) {
                    countHarvestVegetables(matrix, row, currentCol);
                    matrix[row][currentCol] = " ";
                }
            }
        }
    }

    private static void moveDown(String[][] matrix, int row, int col) {
        if (row < matrix.length && row >= 0) {

            if (row % 2 == 0) {
                for (int currentRow = row; currentRow < matrix.length; currentRow += 2) {
                    countHarvestVegetables(matrix, currentRow, col);
                    matrix[currentRow][col] = " ";
                }
            } else {
                for (int currentRow = row; currentRow < matrix.length; currentRow += 2) {
                    countHarvestVegetables(matrix, currentRow, col);
                    matrix[currentRow][col] = " ";
                }
            }
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

    private static void moveUp(String[][] matrix, int row, int col) {
        if (row >= 0 && row < matrix.length) {

            if (row % 2 == 0) {
                for (int currentRow = row; currentRow >= 0; currentRow -= 2) {
                    countHarvestVegetables(matrix, currentRow, col);
                    matrix[currentRow][col] = " ";
                }
            } else {
                for (int currentRow = row; currentRow >= 1; currentRow -= 2) {
                    countHarvestVegetables(matrix, currentRow, col);
                    matrix[currentRow][col] = " ";
                }
            }
        }
    }
}
