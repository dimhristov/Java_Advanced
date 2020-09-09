package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p6_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scan.nextLine().split("\\s+");
        Collections.addAll(queue, input);
        int count = Integer.parseInt(scan.nextLine());

        while (queue.size() > 1) {
            for (int i = 1; i < count; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
