package com.company.GenericSwapMethodString;

public class Box<E> {
    private E data;

    public Box(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + data;
    }

}
