package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p8_BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();
        String current = "";
        String forward = " ";

        String input = scan.nextLine();

        while (!"Home".equals(input)) {
            if (input.equals("back")) {
                if (stack.isEmpty() || stack.size() ==1 ) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stack.poll());
                    System.out.println(stack.peek());
                    if (stackForward.peek() != null) {
                        stack.push(stackForward.peek());
                    }
                }

            } else if (input.equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(stackForward.poll());
                }

            } else {
                stack.push(input);
                System.out.println(input);
            }


            input = scan.nextLine();
        }

    }
}
