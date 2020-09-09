package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p12_BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> queue= new ArrayDeque<>();

        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        String[] numbers = scan.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            queue.add(Integer.valueOf(numbers[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(printSmallestElement(queue));
            } else {
                System.out.println(0);
            }
        }
    }

    private static int printSmallestElement(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : queue) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
