package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p7_MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scan.nextLine().split("\\s+");
        Collections.addAll(queue, input);
        int count = Integer.parseInt(scan.nextLine());

        int index = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < count; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(index)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            index++;
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
