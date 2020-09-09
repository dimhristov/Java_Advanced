package com.company.p4_RawData;

public class Cargo {
    int cargoWeight;
    String cargoType;

    public String getCargoType() {
        return this.cargoType;
    }

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}
