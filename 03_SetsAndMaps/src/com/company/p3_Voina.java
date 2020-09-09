package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class p3_Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {
            int firstCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstCard);

            int secondCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (firstCard < secondCard) {
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }

        }
        String output = "Draw!";
        if (firstPlayerCards.size() < secondPlayerCards.size()) {
            output = "Second player win!";
        } else {
            output = "First player win!";
        }
        System.out.println(output);
    }
}
