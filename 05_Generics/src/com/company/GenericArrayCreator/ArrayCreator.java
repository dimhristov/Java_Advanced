package com.company.GenericArrayCreator;

import java.util.Objects;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return  array;
    }

}
