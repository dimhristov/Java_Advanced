package com.company.p8_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<Person> ppl = new ArrayList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name,age,town);
            ppl.add(person);
            input = reader.readLine();
        }

        int equalCount = 0;
        int notEqualCount =0;
        int index = Integer.parseInt(reader.readLine()) -1;
        Person target = ppl.get(index);


        for (Person person : ppl) {
            if (person.compareTo(target) == 0) {
                equalCount++;
            } else{
                notEqualCount++;
            }
        }
        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d",equalCount,notEqualCount,ppl.size());
        }
    }
}
