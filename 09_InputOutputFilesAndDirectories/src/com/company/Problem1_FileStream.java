package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Problem1_FileStream {
    public static void main(String[] args) throws IOException {
        String entirePath = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\03_InputOutputFilesAndDirectories\\Resources_Lab\\";
        String path = entirePath + "input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                System.out.print(oneByte + " ");
                oneByte = fis.read();
            }
        } catch (IOException e) {
            System.err.println("There was and error");
        }


    }
}
