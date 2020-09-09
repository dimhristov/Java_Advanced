package com.company;

import java.io.*;

public class Problem4_CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {


        String entirePath = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\03_InputOutputFilesAndDirectories\\Resources_Lab\\";
        String path = entirePath + "input.txt";
        String outputPath = entirePath + "outputTextDocument.txt";


        try (InputStream fis = new FileInputStream(path);
             OutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    fos.write(oneByte);
                } else {
                    fos.write(oneByte);
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fos.write(digits.charAt(i));

                    }
                }
            }
                oneByte = fis.read();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
