package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> appender = s -> System.out.println(("Sir " + s));

        Arrays.stream(scan.nextLine().split(" ")).forEach(appender);
    }
}
