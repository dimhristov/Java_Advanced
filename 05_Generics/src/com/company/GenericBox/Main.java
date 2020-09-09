package com.company.GenericBox;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(scan.readLine());

        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(scan.readLine());
            System.out.println(box  );
        }
    }
}
