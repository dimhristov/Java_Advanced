package com.company.p4_RawData;

public class Tire {
    double tirePressure;
    int tireAge;

    public double getTirePressure() {
        return this.tirePressure;
    }

    public int getTireAge() {
        return this.tireAge;
    }

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

}
