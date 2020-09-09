package com.company;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p9_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();


        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();


        for (int i = 0; i < n; i++) {
            int firstNum = scan.nextInt();
            firstSet.add(firstNum);
        }
        for (int i = 0; i < m; i++) {
            int firstNum = scan.nextInt();
            secondSet.add(firstNum);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(number -> System.out.print(number +" "));

    }
}
