package com.company.p6_PokemonChallenge;

// task  https://softuni.bg/trainings/resources/officedocument/49860/exercise-problem-descriptions-java-advanced-may-2020/2836

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Trainer> trainers = new LinkedList<>();

        String input = scan.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);


            boolean exist = false;
            int index = 0;
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().equals(trainerName)) {
                    exist = true;
                    index = i;
                    break;
                }
            }
            if (!exist) {
                Trainer trainer = new Trainer(trainerName);
                Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                trainer.setPokemons(pokemon);
                trainers.add(trainer);
            } else {
                Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                Trainer currentTrainer = trainers.get(index);
                currentTrainer.setPokemons(pokemon);

            }

            input = scan.nextLine();
        }
        String cmd;
        while (!(cmd = scan.nextLine()).equals("End")) {
            switch (cmd) {
                case "Fire":
                    boolean flag = false;
                    for (Trainer trainer : trainers) {
                        for (Pokemon pokemon : trainer.getPokemons()) {
                            if (pokemon.getElement().equals("Fire")) {
                                trainer.setBadges(trainer.getBadges() + 1);
                                flag = true;
                                continue;
                            }
                        }
                        if (!flag) {

                                for (Pokemon pokemon : trainer.getPokemons()) {
                                    pokemon.setHealth(pokemon.getHealth() - 10);
                                    if (pokemon.getHealth() <= 0) {
                                        trainer.getPokemons().remove(pokemon);
                                    }
                                    if (!trainer.getPokemons().isEmpty()) {
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case "Water":
                    flag = false;
                    for (Trainer trainer : trainers) {
                        for (Pokemon pokemon : trainer.getPokemons()) {
                            if (pokemon.getElement().equals("Water")) {
                                trainer.setBadges(trainer.getBadges() + 1);
                                flag = true;
                                continue;
                            }
                        }
                        if (!flag) {
                            if (!trainer.getPokemons().isEmpty()) {
                                for (Pokemon pokemon : trainer.getPokemons()) {
                                    pokemon.setHealth(pokemon.getHealth() - 10);
                                    if (pokemon.getHealth() <= 0) {
                                        trainer.getPokemons().remove(pokemon);
                                    }
                                    if (!trainer.getPokemons().isEmpty()) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "Electricity":
                    flag = false;
                    for (Trainer trainer : trainers) {
                        for (Pokemon pokemon : trainer.getPokemons()) {
                            if (pokemon.getElement().equals("Electricity")) {
                                trainer.setBadges(trainer.getBadges() + 1);
                                flag = true;
                                continue;
                            }
                        }
                        if (!flag) {

                            for (Pokemon pokemon : trainer.getPokemons()) {
                                pokemon.setHealth(pokemon.getHealth() - 10);
                                if (pokemon.getHealth() <= 0) {
                                    trainer.getPokemons().remove(pokemon);
                                }
                                if (trainer.getPokemons().isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }

        }
        trainers.stream()
                .sorted((t1,t2) -> Integer.compare(t2.getBadges(),t1.getBadges()) )
                .forEach(trainer -> System.out.println(trainer.getName() + " " + trainer.getBadges() + " " + trainer.getPokemons().size()));

    }
}

