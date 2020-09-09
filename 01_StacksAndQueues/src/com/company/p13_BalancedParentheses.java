package com.company;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class p13_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        if (input.length() % 2 == 1 || input.length() == 0) {
            System.out.println("NO");
            return;
        }

        int middle = input.length() / 2;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            switch (symbol) {
                case '{':
                case '(':
                case '[':
                    stack.push(symbol);
                    break;
                case '}':
                    if (stack.size() > 0 && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case ')':
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case ']':
                    if (stack.size() > 0 && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    break;
            }
        }

        if (stack.size() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}