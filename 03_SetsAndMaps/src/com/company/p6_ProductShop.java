package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p6_ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shop = new TreeMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("Revision")) {
            String[] tokens = input.split(", ");
            String storeName = tokens[0];
            String productName = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shop.putIfAbsent(storeName, new LinkedHashMap<>());
            shop.get(storeName).put(productName,price);
        }


        shop.forEach((storeName,products) -> {
            System.out.println(storeName + "->");
            products.forEach((productName,productPrice) -> {
                System.out.println(String.format("Product: %s, Price: %.1f",productName,productPrice));
            });
        });
    }
}
