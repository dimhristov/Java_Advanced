package com.company.p5_Collection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ListyIterator listyIterator = null;
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    listyIterator = new ListyIterator(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }

            input = reader.readLine();
        }
    }
}
