package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstInput = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();



        Deque<Integer> firstQueue = new ArrayDeque<>();
        for (int item : firstInput) {
            firstQueue.offer(item);
        }
        Deque<Integer> secondStack = new ArrayDeque<>();
        for (int item : secondInput) {
            secondStack.push(item);
        }
        int sum = 0;
        int currentSum =0;

        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
            currentSum = firstQueue.peek() + secondStack.peek();
            if (numberIsEven(currentSum)) {
                sum +=currentSum;
                firstQueue.poll();
                secondStack.pop();
            } else {
                firstQueue.offer(secondStack.pop());
            }
        }
        if (firstQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: "+ sum);
        }


    }

    private static boolean numberIsEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else{
            return false;
        }
    }
}
