package RetakeExam2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> firstStack2 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> firstStack = new ArrayDeque<>();
        for (Integer integer : firstStack2) {
            firstStack.push(firstStack2.pop());
        }
        Deque<Integer> secondQueue = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        //stack - push and pop
        //queue - offer - poll
        while (!firstStack.isEmpty() && !secondQueue.isEmpty()) {
            int material = firstStack.peek();
            int magic = secondQueue.peek();
            int multiplied = magic * material;
            if (multiplied == 150 || multiplied == 250 || multiplied == 300 || multiplied == 400) {
                // we have crafted an object
                switch (multiplied) {
                    case 150:
                        presents.put("Doll", presents.get("Doll") + 1);
                        break;
                    case 250:
                        presents.put("Wooden train", presents.get("Wooden train") + 1);
                        break;
                    case 300:
                        presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                        break;
                    case 400:
                        presents.put("Bicycle", presents.get("Bicycle") + 1);
                        break;
                }
                firstStack.pop();
                secondQueue.poll();
            } else if (multiplied < 0) {
                int sum = material + magic;
                firstStack.pop();
                secondQueue.poll();
                firstStack.push(sum);
            } else if (multiplied > 0) {
                secondQueue.poll();
                firstStack.push(firstStack.pop() + 15);
            } else if (material == 0 || magic == 0) {
                if (material == 0) {
                    firstStack.pop();
                } else if (magic == 0) {
                    secondQueue.poll();
                }
            }
        }

        if ((presents.get("Doll") > 0 && presents.get("Wooden train") > 0) || (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        System.out.print("Materials left: ");
        if (!firstStack.isEmpty()) {
            for (int i = 0; i < firstStack.size(); i++) {
                System.out.print(firstStack.pop() +", ");
            }
            System.out.print(firstStack.pop());
        }
        if (!secondQueue.isEmpty()) {
            for (int i = 0; i < secondQueue.size(); i++) {
                System.out.print(secondQueue.poll() +", ");
            }
            System.out.print(secondQueue.poll());
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(String.format("%s: %d",entry.getKey(),entry.getValue()));
            }
        }
    }
}
