package com.company;

import java.io.File;

public class Problem_6_GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "D:\\JAVA\\SoftUni\\03_JavaAdvanced\\03_InputOutputFilesAndDirectories\\Resources_Lab\\" +
                "resources-excercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file = new File(pathFolder );
        long size = folderSize(file);

        System.out.println(size);



      //  int size = folderSize()


    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                length += file.length();
            } else{
                length +=folderSize(file);
            }
        }
        return  length;
    }

}
