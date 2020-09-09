package com.company.ListUtilities;

import java.util.List;

public class ListUtilities<T> {

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        return list.stream().max(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        return list.stream().min(T::compareTo).orElse(null);
    }



}
