package com.company.p6_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String line = scan.readLine();
        line = line.replaceAll(",","");
        String[] tokens = line.split("\\s+");

        Stack stack = new Stack();
        while (!tokens[0].equals("END")) {
            switch (tokens[0]) {
                case "Push":
                    String[] list = Arrays.copyOfRange(tokens, 1, tokens.length);
                    Integer[] intList = Arrays.stream(list).map(Integer::parseInt).toArray(Integer[]::new);
                    stack.push(intList);

                    break;
                case "Pop":
                    stack.pop();
                    break;
            }


            tokens = scan.readLine().split("\\s+");
        }
        for (Integer integer : stack) {
            System.out.println(integer );
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
