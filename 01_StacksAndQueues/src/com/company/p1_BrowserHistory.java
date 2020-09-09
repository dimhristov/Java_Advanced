package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> browser = new ArrayDeque<>();

        String input = scan.nextLine();
        String current = "";

        while (!"Home".equals(input)) {
            if (input.equals("back")) {
                if (!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    browser.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = scan.nextLine();
        }

    }
}

