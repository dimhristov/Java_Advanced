package com.company;

import java.util.*;

public class p15_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> people = new LinkedHashMap<>();


        String input = scan.nextLine();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            if (!people.containsKey(name)) {
                people.put(name, new HashSet<>());
                people.get(name).addAll(Arrays.asList(cards));
            } else {
                people.get(name).addAll(Arrays.asList(cards));
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : people.entrySet()) {
            int sum = 0;
            for (String value : entry.getValue()) {
                String numCard,cardColor;
                if (value.length() >= 3) {
                     numCard = value.toString().substring(0,2);
                     cardColor = value.toString().substring(2);
                } else {

                     numCard = value.toString().substring(0, 1);
                     cardColor = value.toString().substring(1);
                }
                    int power =0;
                    int multiplier = 0;
                    switch (numCard) {
                        case "2": power = 2; break;
                        case "3": power = 3; break;
                        case "4": power = 4; break;
                        case "5": power = 5; break;
                        case "6": power = 6; break;
                        case "7": power = 7; break;
                        case "8": power = 8; break;
                        case "9": power = 9; break;
                        case "10": power = 10; break;
                        case "J": power = 11; break;
                        case "Q": power = 12; break;
                        case "K": power = 13; break;
                        case "A": power = 14; break;
                    }
                    switch (cardColor) {
                        case "S": multiplier = 4; break;
                        case "H": multiplier = 3; break;
                        case "D": multiplier = 2; break;
                        case "C": multiplier = 1; break;
                    }
                    sum += (power * multiplier);
                }

            System.out.println(String.format("%s: %d",entry.getKey(),sum));
        }

    }
}
