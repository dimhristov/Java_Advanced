package com.company;

//task 9 - https://softuni.bg/trainings/resources/officedocument/49849/exercise-problem-descriptions-java-advanced-may-2020/2836

import java.util.Scanner;

public class p_18_ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        //matrix - 0-empty space
        //         1- parked car
        int[][] parkingLot = new int[rows][cols];

        String input = "";
        while (!(input = scan.nextLine()).equals("stop")) {
            int travelCounter = 1;
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);


            int carRow = entryRow;
            int carCol = 0;
            travelCounter += targetRow - entryRow;
            travelCounter +=targetCol;
//            for (int row = entryRow; row <= targetRow; row++) {
//                travelCounter++;
//            }
//            for (int col = 0; col < targetCol; col++) {
//                travelCounter++;
//            }
            // if the spot is empty- park here, else ..
            while (true) {
                if (!itIsBusy(parkingLot, targetRow, targetCol)) {
                    parkingLot[targetRow][targetCol] = 1; //if the cell is 1 it means there is a parked car
                    System.out.println(travelCounter);
                    break;
                } else {
                    carRow = targetRow;
                    carCol = targetCol - 1;
                    if (!itIsBusy(parkingLot, carRow, carCol)) {
                        travelCounter--;
                        parkingLot[carRow][carCol] = 1;
                        System.out.println(travelCounter);
                        break;
                    } else {
                        carCol = targetCol + 1;
                        if (!itIsBusy(parkingLot, carRow, carCol)) {
                            travelCounter++;
                            parkingLot[carRow][carCol] = 1;
                            System.out.println(travelCounter);
                            break;
                        }
                    }
                }
                travelCounter = 0;
                if (entireRowIsBusy(parkingLot, targetRow)) {
                    System.out.println(String.format("Row %d full", targetRow));
                    break;
                }
            }
        }


         printMatrix(rows, cols, parkingLot);


    }

    private static boolean entireRowIsBusy(int[][] parkingLot, int targetRow) {
        for (int col = 1; col < parkingLot[targetRow].length; col++) {
            if (parkingLot[targetRow][col] != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean itIsBusy(int[][] parkingLot, int targetRow, int targetCol) {
        return parkingLot[targetRow][targetCol] == 1;
    }

    private static void printMatrix(int rows, int cols, int[][] parkingLot) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(parkingLot[row][col] + " ");
            }
            System.out.println();
        }
    }
}
