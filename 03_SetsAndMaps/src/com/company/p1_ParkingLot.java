package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p1_ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split(", ");
            String cmd = tokens[0];
            String carNumber = tokens[1];

            switch (cmd) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
            }
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String s : parkingLot) {
            System.out.println(s);
        }
    }
}
