package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p12_PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputContact = scan.nextLine();

        Map<String,String> phoneBook = new HashMap<>();
        while (!inputContact.equals("search")) {
            String[] tokens = inputContact.split("-");
            String name = tokens[0];
            String phoneNum = tokens[1];

            phoneBook.put(name,phoneNum);

            inputContact= scan.nextLine();
        }
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String nameToCheck = input;
            if (phoneBook.containsKey(nameToCheck)) {
                System.out.println(String.format("%s -> %s",nameToCheck,phoneBook.get(nameToCheck)));
            } else {
                System.out.println(String.format("Contact %s does not exist.",nameToCheck));
            }
            input = scan.nextLine();
        }
    }
}
