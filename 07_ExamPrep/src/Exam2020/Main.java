package Exam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstInput = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        // this is stack
        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        //this is queueu
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        boolean firstFlag = false;
        boolean secondFlag = false;
        boolean thirdFlag = false;
        boolean pouchIsFilled = false;




        for (int element : firstInput) {
            bombEffect.offer(element);
        }
        for (int element : secondInput) {
            bombCasing.push(element);
        }
        //--------------------------------
        while (!bombEffect.isEmpty() && !bombCasing.isEmpty() && !pouchIsFilled ) {
            int firstElement = bombEffect.peek();
            int secondElement = bombCasing.peek();
            int sum = firstElement + secondElement;

            if (sum == 40) {
                bombEffect.poll();
                bombCasing.pop();
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                if (bombs.get("Datura Bombs") == 3) {
                    firstFlag =true;
                }
            } else if (sum == 60) {
                bombEffect.poll();
                bombCasing.pop();
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                if (bombs.get("Cherry Bombs") == 3) {
                    secondFlag =true;
                }
            } else if (sum == 120) {
                bombEffect.poll();
                bombCasing.pop();
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                if (bombs.get("Smoke Decoy Bombs") == 3) {
                    thirdFlag =true;
                }
            } else {
                bombCasing.push(bombCasing.pop() - 5);
            }
        pouchIsFilled = checkIfPouchIsFilled(bombs);
        }
        if (pouchIsFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            List<Integer> printArray = new ArrayList<>();
            printArray.addAll(bombEffect);
            for (int i = 0; i < printArray.size() - 1; i++) {
                System.out.print(printArray.get(i) +", ");
            }
            System.out.println(printArray.get(printArray.size()-1));
        }
        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            List<Integer> printArray = new ArrayList<>();
            printArray.addAll(bombCasing);
            for (int i = 0; i < printArray.size() - 1; i++) {
                System.out.print(printArray.get(i) +", ");
            }
            System.out.println(printArray.get(printArray.size()-1));
        }

        for (Map.Entry<String, Integer> e : bombs.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }

    private static boolean checkIfPouchIsFilled(Map<String, Integer> bombs) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            if (entry.getValue() >= 3) {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
