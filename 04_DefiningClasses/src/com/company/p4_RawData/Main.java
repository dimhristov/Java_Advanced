package com.company.p4_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Tire[] carTires = new Tire[]{tire1, tire2, tire3, tire4};
            // to do create a new car make a collection to keep all the cars
            Car car = new Car(model, engine, cargo, carTires);
            cars.add(car);
        }
        String cmd = scan.nextLine();
        switch (cmd) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargo()
                                .getCargoType().equals("fragile"))
                        .filter(car -> car.checkPressure(car.getTires()))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargo()
                                .getCargoType().equals("flamable"))
                        .filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}
