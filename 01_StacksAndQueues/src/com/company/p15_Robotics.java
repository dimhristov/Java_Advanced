package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p15_Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(";");
        int[] timeTokens = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int time = (timeTokens[0] * 3600) + (timeTokens[1] * 60) + timeTokens[2]; //time in seconds
        int[] worktime = new int[input.length];

        ArrayDeque<String> productQueue = new ArrayDeque<>();

        String[] robots = new String[input.length];   //names of robots
        int[] processingTime = new int[input.length]; //processing time of robots

        for (int i = 0; i <input.length ; i++) {
            String[] robotTokens = input[i].split("-");
            int robotTime = Integer.parseInt(robotTokens[1]);
            processingTime[i] = robotTime;
            robots[i] = robotTokens[0];
        }

        String productsInput = "";
        while (!"End".equals(productsInput = scan.nextLine())) {
            productQueue.add(productsInput);
        }

        while (!productQueue.isEmpty()) {
            time++;

            String product = productQueue.poll();
            boolean isWorking = false;

            for (int i = 0; i < robots.length; i++) {
                if (worktime[i] == 0 && !isWorking) {
                    worktime[i] = processingTime[i];
                    isWorking=true;
                    printRobotData(robots[i], product, time);
                }
                if (worktime[i] > 0) {
                    worktime[i]--;
                }
            }
            if ((!isWorking)) {
                productQueue.offer(product);
            }

        }
    }
    private static void printRobotData(String robot, String product, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;
        System.out.println(robot + " - " + product +
                String.format(" [%02d:%02d:%02d] ", h, m, s));
    }
}
