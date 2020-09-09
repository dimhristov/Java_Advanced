package com.company;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class p8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, double[]> students = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String name = scan.nextLine();
            double[] grades =Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            students.putIfAbsent(name, grades);

        }
         students.forEach((student,grades) ->{
             //double average = Arrays.stream(grades).average().getAsDouble();
             double sum = 0;
             for (double grade : grades) {
                 sum +=grade;
             }
             sum = sum/grades.length;

             String averagePrint = new DecimalFormat("#.##################").format(sum);
             System.out.println(String.format("%s is graduated with %s",student,averagePrint));
         });
    }
}
