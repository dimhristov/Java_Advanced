package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p9_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = scan.nextLine().split("\\s+");
        for (String s : input) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() +" ");
        }
    }
}
