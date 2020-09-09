package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p11_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character, Integer> occurance = new TreeMap<>();

        char[] input = scan.nextLine().toCharArray();

        for (char c : input) {
            if (!occurance.containsKey(c)) {
                occurance.put(c, 1);
            } else {
                occurance.put(c,occurance.get(c) + 1);
            }
        }
        occurance.forEach((c,count) -> {
            System.out.println(String.format("%c: %d time/s",c,count));
        });
    }
}
