package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p11_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String cmd = tokens[0];

            switch (cmd) {
                case "1":
                    String element = tokens[1];
                    stack.push(Integer.valueOf(element));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(printMaximumElement(stack));
                    break;
            }

        }

    }

    private static int printMaximumElement(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }
}
