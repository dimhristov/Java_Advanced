package com.company.p5_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {

        return String.format("%s:%n%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s",model,engine.getModel(),engine.getPower(),
                engine.getDisplacement() ==0 ? "n/a" : engine.getDisplacement(),
                engine.getEfficiency() == null ? "n/a" : engine.getEfficiency(),
                weight ==0 ? "n/a" : weight,
                color == null ? "n/a" : color);
    }

}
