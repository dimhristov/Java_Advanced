package com.company.p9_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> ppl = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String cmd = tokens[1];
            if (!ppl.containsKey(name)) {
                Person person = new Person(name);
                ppl.put(name, person);
            }

            switch (cmd) {
                case "company":
                    String companyName = tokens[2];
                    String companyDepartment = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, companyDepartment, salary);
                    ppl.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    ppl.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    ppl.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childrenName = tokens[2];
                    String childrenBirthday = tokens[3];
                    Children children = new Children(childrenName, childrenBirthday);
                    ppl.get(name).getChildrens().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    Car car = new Car(carModel,carSpeed);
                    ppl.get(name).setCar(car);
                    break;
            }

            input = scan.nextLine();
        }
        String searchName = scan.nextLine();
        if (ppl.containsKey(searchName)) {
            System.out.println(ppl.get(searchName));
        }
    }
}
