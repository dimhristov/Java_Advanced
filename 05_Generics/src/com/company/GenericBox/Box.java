package com.company.GenericBox;

import java.util.Deque;

public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }
}
