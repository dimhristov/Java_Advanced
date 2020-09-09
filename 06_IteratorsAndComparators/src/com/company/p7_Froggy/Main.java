package com.company.p7_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Lake lake = null;
        while (!input.equals("END")) {
            int[] tokens = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
             lake = new Lake(tokens );
            input = reader.readLine();
        }

        String output = "";
        for (Integer integer : lake) {
            output += integer + ", ";
        }
        System.out.println(output.substring(0,output.length()-2));

    }
}
