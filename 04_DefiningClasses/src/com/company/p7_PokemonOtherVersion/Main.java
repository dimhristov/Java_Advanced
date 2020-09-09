package com.company.p7_PokemonOtherVersion;




import java.util.*;

class Pokemon {

    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }



    String getElement() {
        return element;
    }


    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }
}


class Trainerr {
    private String name;
    private int badges = 0;



    Trainerr(String name) {
        this.name = name;

    }

    String getName() {
        return name;
    }


    int getBadges() {
        return badges;
    }

    void setBadges(int badges) {
        this.badges = badges;
    }


}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Trainerr, ArrayList<Pokemon>> trainers  = new LinkedHashMap<>();


        String command;
        while (!(command = scanner.nextLine()).equals("Tournament")){

            String[] tokens = command.split("\\s+");
            Trainerr trainer = null;
            boolean isFound = false;


            for (Map.Entry<Trainerr, ArrayList<Pokemon>> entry : trainers.entrySet()) {
                if (entry.getKey().getName().equals(tokens[0])){
                    isFound = true;
                    trainer = entry.getKey();
                    break;
                }
            }

            if (!isFound){
                trainer = new Trainerr(tokens[0]);
                trainers.putIfAbsent(trainer, new ArrayList<>());
            }




            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]));

            trainers.get(trainer).add(pokemon);


        }
        command = scanner.nextLine();
        while (!command.equals("End")){


            for (Map.Entry<Trainerr, ArrayList<Pokemon>> entry : trainers.entrySet()) {
                boolean hasElement = false;
                switch (command) {


                    case "Fire": {
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (entry.getValue().get(i).getElement().equals("Fire")) {
                                hasElement = true;
                                break;
                            }
                        }
                        if (hasElement){
                            entry.getKey().setBadges(entry.getKey().getBadges() + 1);
                        }
                        else {
                            for (int i = 0; i < entry.getValue().size(); i++) {

                                entry.getValue().get(i).setHealth(entry.getValue().get(i).getHealth() - 10);

                                if (entry.getValue().get(i).getHealth() <= 0) {
                                    entry.getValue().remove(entry.getValue().get(i));
                                }
                            }
                        }
                    }
                    break;

                    case "Water":{
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (entry.getValue().get(i).getElement().equals("Water")) {
                                hasElement = true;
                                break;
                            }
                        }
                        if (hasElement){
                            entry.getKey().setBadges(entry.getKey().getBadges() + 1);
                        }
                        else {
                            for (int i = 0; i < entry.getValue().size(); i++) {

                                entry.getValue().get(i).setHealth(entry.getValue().get(i).getHealth() - 10);

                                if (entry.getValue().get(i).getHealth() <= 0) {
                                    entry.getValue().remove(entry.getValue().get(i));
                                }
                            }
                        }
                    }
                    break;

                    case "Electricity":{
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (entry.getValue().get(i).getElement().equals("Electricity")) {
                                hasElement = true;
                                break;
                            }
                        }
                        if (hasElement){
                            entry.getKey().setBadges(entry.getKey().getBadges() + 1);
                        }
                        else {
                            for (int i = 0; i < entry.getValue().size(); i++) {

                                entry.getValue().get(i).setHealth(entry.getValue().get(i).getHealth() - 10);

                                if (entry.getValue().get(i).getHealth() <= 0) {
                                    entry.getValue().remove(entry.getValue().get(i));
                                }
                            }
                        }
                    }
                    break;
                }
            }
            command = scanner.nextLine();

        }

        trainers.entrySet()
                .stream()
                .sorted((t1,t2) ->
                        t2.getKey().getBadges() - t1.getKey().getBadges()
                )
                .forEach(t -> System.out.println(t.getKey().getName() + " " + t.getKey().getBadges() +" " + t.getValue().size()));

    }

}