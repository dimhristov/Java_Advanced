package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Problem2_ReadAFile {
    public static void main(String[] args) {
        String entirePath = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\03_InputOutputFilesAndDirectories\\Resources_Lab\\";
        String path = entirePath + "input.txt";

        try(InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                String binaryArray = Integer.toBinaryString(oneByte);
                System.out.print(binaryArray + " ");
                oneByte = in.read();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
