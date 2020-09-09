package com.company;

import java.util.Scanner;

public class TelerikTask_Gold {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int smallBars = Integer.parseInt(scan.nextLine());
        int bigBars = Integer.parseInt(scan.nextLine());
        int killos = Integer.parseInt(scan.nextLine());

//        int small = 1;
//        int big = 5;
        int bigBarsToTake = 0;


        while (bigBarsToTake < killos) {
            if (bigBars > 0) {
                bigBarsToTake +=5;
                bigBars--;
            } else {
                break;
            }
        }
        if (bigBarsToTake > killos) {
            bigBarsToTake -= 5;
        }
        if (bigBarsToTake == killos) {
            System.out.println(0);
        }
        if (bigBarsToTake < killos) {
            int neededSmall = killos-bigBarsToTake;
            if (neededSmall <= smallBars) {
                System.out.println(neededSmall);
            } else {
                System.out.println(-1);
            }
        }
    }
}
