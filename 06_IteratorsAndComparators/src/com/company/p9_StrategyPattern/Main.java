package com.company.p9_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> byName = new TreeSet<>(new CompareByName());
        Set<Person> byAge = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            byName.add(person);
            byAge.add(person);
        }
        for (Person person : byName) {
            System.out.println(person);
        }
        for (Person person : byAge) {
            System.out.println(person);
        }

    }
}
