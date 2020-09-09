package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            if (input.length() != 8) {
                continue;
            }
            if (Character.isDigit(input.charAt(0))) {
                VIP.add(input);
            } else {
                regular.add(input);
            }

            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                VIP.remove(input);
            } else {
                regular.remove(input);

            }

            input = scan.nextLine();
        }
        System.out.println(VIP.size() + regular.size());
        for (String vip : VIP) {
            System.out.println(vip);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
