package com.company.p4_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    public double calculatePressure(Tire[] tires) {
        double total = 0;
        for (Tire tire : tires) {
            total += tire.getTirePressure();
        }
        total /= 4;
        return total;
    }

    public boolean checkPressure(Tire[] tires) {
        for (Tire tire : tires) {
            if (tire.getTirePressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }
}
