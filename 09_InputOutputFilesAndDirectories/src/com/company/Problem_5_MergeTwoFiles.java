package com.company;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_5_MergeTwoFiles {
    public static void main(String[] args) {

        String pathOne = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\" +
                "03_InputOutputFilesAndDirectories\\Resources_Lab\\resources-excercise\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt";
        String pathTwo = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\" +
                "03_InputOutputFilesAndDirectories\\Resources_Lab\\resources-excercise\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt";
        String outputPath = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\" +
                "03_InputOutputFilesAndDirectories\\Resources_Lab\\resources-excercise\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\merged.txt";



        try (Scanner scan = new Scanner(new FileInputStream(pathOne));
             Scanner scanSecond = new Scanner(new FileInputStream(pathTwo));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {

            while (scan.hasNextLine()) {
                out.println(scan.nextLine());
            }
            while (scanSecond.hasNextLine()) {
                out.println(scanSecond.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
