package com.company;

import java.util.Scanner;

public class p14_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rotations = Integer.parseInt(scan.nextLine().split("[\\(\\)]")[1]);

        String line = "";
        String input = "";
        int maxLength = 0;
        while (!(input = scan.nextLine()).equals("END")) {
            line += input + "\n";

            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }
        String[] matrix = line.split("\n");
        rotations %= 360;

        String output = "";

        switch (rotations) {
            case 0:
                System.out.println(String.join("\n", matrix));
                break;
            case 90:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = matrix.length-1; j >= 0; j--) {

                        try {
                            output += matrix[j].charAt(i);
                        } catch (Exception e) {
                            output += " ";
                        }
                    }
                    output += "\n";
                }
                System.out.println(output);
                break;
            case 180:
                System.out.println(new StringBuilder(line).reverse());
                break;
            case 270:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = matrix.length-1; j >= 0; j--) {

                        try {
                            output += matrix[j].charAt(i);
                        } catch (Exception e) {
                            output += " ";
                        }
                    }
                    output += "\n";
                }
                System.out.println(new StringBuilder(output).reverse());
                break;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
