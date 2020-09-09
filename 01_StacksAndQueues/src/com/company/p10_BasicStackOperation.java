package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p10_BasicStackOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] tokens = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        String[] numberTokens = scan.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            stack.push(Integer.valueOf(numberTokens[i]));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(smallestElement(stack));
        }
    }

    private static int smallestElement(ArrayDeque<Integer> stack) {
        int smallestElement = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            return 0;
        }
        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (a < smallestElement) {
                smallestElement = a ;
            }
        }
        return  smallestElement;
    }
}
