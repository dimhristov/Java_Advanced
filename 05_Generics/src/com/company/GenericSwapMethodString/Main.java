package com.company.GenericSwapMethodString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());


        List<Box<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(Integer.parseInt(reader.readLine())));
        }
        String[] tokens = reader.readLine().split(" ");
        int indexes1 = Integer.parseInt(tokens[0]);
        int indexes2 = Integer.parseInt(tokens[1]);


        swapElements(boxes,indexes1,indexes2);

        for (Box<Integer> box : boxes) {
            System.out.println(box);
        }
    }

    private static <E> void swapElements(List<E> list, int firstIndex, int secondIndex) {
        E firstElement = list.get(firstIndex);
        E secondElement = list.get(secondIndex);

        list.set(firstIndex,secondElement);
        list.set(secondIndex,firstElement);
    }
}
