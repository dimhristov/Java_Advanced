package com.company;

import java.util.*;

public class p7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            earth.putIfAbsent(continent,new LinkedHashMap<>());
            earth.get(continent).putIfAbsent(country,new ArrayList<>());
            earth.get(continent).get(country).add(city);
        }

        earth.forEach((continent,countries) -> {
            System.out.println(String.format("%s:", continent));
            countries.forEach((country,city) -> {
                System.out.print(country + " -> ");
                System.out.println(String.join(", ",city));
            });
        });
    }
}
