package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p2_SimpleCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scan.nextLine().split(" ");

        for (int i = input.length-1; i >= 0; i--) {
            stack.push(input[i]);
        }
        int sum = Integer.parseInt(stack.pop());

        while (stack.size() > 1) {
            String operand = stack.pop();
            int a = Integer.parseInt(stack.pop());


            if (operand.equals("+")) {
                sum += a ;
            } else if (operand.equals("-")) {
                sum -= a;
            }
        }
        System.out.println(sum);
    }
}
