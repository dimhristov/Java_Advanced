package com.company.GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box<String>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(reader.readLine()));
        }

        Box compareWith = new Box<>(reader.readLine());
        System.out.println(genericCount(boxes,compareWith));
    }

    private static  int genericCount(List<Box<String>> list, Box<String> target) {
        int count = 0;

        for (Box<String> box : list) {
            if (box.compareTo(target.getData()) > 0) {
                count++;
            }
        }
        return count;
    }
}
