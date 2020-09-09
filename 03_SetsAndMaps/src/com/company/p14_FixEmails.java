package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p14_FixEmails   {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,String> emails = new LinkedHashMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("stop")) {
            String email = scan.nextLine();
            String[] tokens = email.split("\\.");
            if (!tokens[1].equals("us") && !tokens[1].equals("uk") && !tokens[1].equals("com")) {
                emails.put(input,email);
            }
        }
//        for (Map.Entry<String, String> entry : emails.entrySet()) {
//            String[] tokens = entry.getValue().split("\\.");
//            if (tokens[1].equals("us") || tokens[1].equals("uk") || tokens[1].equals("com")) {
//                emails.remove(entry.getKey());
//            }
//        }

        emails.forEach((name,email) -> {
            System.out.println(String.format("%s -> %s",name,email));
        });
    }
}
