package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3_WriteFile {
    public static void main(String[] args) throws IOException {
        String entirePath = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\03_InputOutputFilesAndDirectories\\Resources_Lab\\";
        String path = entirePath + "input.txt";
        String outputPath = entirePath+ "outputTextDocument.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols,'.',',','!','?');

        try (InputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(outputPath)){
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
