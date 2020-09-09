package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class p5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentBook = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentBook.putIfAbsent(name,new ArrayList<>());
            studentBook.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentBook.entrySet()) {
            System.out.println(String.format("%s -> %s (avg: %.2f)",entry.getKey(),gradesAsString(entry.getValue()),getAverage(entry.getValue())));
        }
    }

    private static String gradesAsString(List<Double> grades) {
        return grades.stream()
                .map(grade -> String.format("%.2f", grade))
                .collect(Collectors.joining(" "));
    }

    private static Double getAverage(List<Double> grades) {
        return grades.stream()
                .mapToDouble(g -> g).average().orElse(0.00);
    }
}
