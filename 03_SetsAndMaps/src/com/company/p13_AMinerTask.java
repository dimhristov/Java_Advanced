package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p13_AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        int counter = 1;
        String current = "";
        Map<String,Integer> metals = new LinkedHashMap<>();
        while (!(input = scan.next()).equals("stop")) {
            if (counter % 2 != 0) {
                metals.putIfAbsent(input,0);
            } else {
                metals.put(current,metals.get(current) + Integer.valueOf(input));
            }

            current = input;
            counter++;
        }
        metals.forEach((name,quantity) -> {
            System.out.println(String.format("%s -> %d",name,quantity));
        });
    }
}
