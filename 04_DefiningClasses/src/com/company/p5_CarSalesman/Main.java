package com.company.p5_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, Engine> engines = new HashMap();
        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engines.put(i, engine);
                    continue;
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    Engine engine = new Engine(model, power,efficiency);
                    engines.put(i, engine);
                    continue;

                }

            } else if (tokens.length > 3) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.put(i, engine);
                continue;
            } else {
                Engine engine = new Engine(model, power);
                engines.put(i, engine);
                continue;
            }
        }
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];
            if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    int index = findKey(engines,engine);
                    Engine carEngine = engines.get(index);
                    Car car = new Car(model, carEngine, weight);
                    cars.add(car);
                    continue;
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    int index = findKey(engines,engine);
                    Engine carEngine = engines.get(index);
                    Car car = new Car(model, carEngine, color);
                    cars.add(car);
                    continue;
                }

            } else if (tokens.length > 3) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                int index = findKey(engines,engine);
                Engine carEngine = engines.get(index);
                Car car = new Car(model, carEngine, weight, color);
                cars.add(car);
                continue;
            } else {
                int index = findKey(engines,engine);
                Engine carEngine = engines.get(index);
                Car car = new Car(model, carEngine);
                cars.add(car);
                continue;
            }


        }
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    private static int findKey(Map<Integer, Engine> engines, String engine) {
        for (Map.Entry<Integer, Engine> entry : engines.entrySet()) {
            if (entry.getValue().getModel().equals(engine)) {
                return entry.getKey();
            }
        }
        return 0;
    }
}


