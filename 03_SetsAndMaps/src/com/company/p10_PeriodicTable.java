package com.company;

import java.util.*;

public class p10_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<String> chemicalCompounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input= scan.nextLine().split("\\s+");
            chemicalCompounds.addAll(Arrays.asList(input));
        }
        for (String chemicalCompound : chemicalCompounds) {
            System.out.print(chemicalCompound + " ");
        }
    }
}
