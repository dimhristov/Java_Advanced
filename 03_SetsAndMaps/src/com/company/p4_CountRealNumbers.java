package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] values = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> valuesWithOccurrences = new LinkedHashMap<>();

        for (double value : values) {
            if (!valuesWithOccurrences.containsKey(value)) {
                valuesWithOccurrences.put(value, 1);
            } else {
                valuesWithOccurrences.put(value, valuesWithOccurrences.get(value) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : valuesWithOccurrences.entrySet()) {
            System.out.println(String.format("%.1f -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
