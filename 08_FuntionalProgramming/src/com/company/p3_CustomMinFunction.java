package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<int[], Integer> function = a -> {
            int min = Integer.MAX_VALUE ;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
            }
            return min;
        };
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(function.apply(numbers));
    }
}
