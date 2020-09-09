package RetakeOct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] malesInput = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] femaleInput = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        int countMatches = 0;

        // male is stack
        for (int i : malesInput) {
            males.push(i);
        }
        //female is queue
        for (int female : femaleInput) {
            females.offer(female);
        }

        while (!males.isEmpty() && !females.isEmpty()) {
            int maleNum = males.peek();
            int femaleNum = females.peek();
            if (maleNum <= 0) {
                males.pop();
                continue;
            }
            if (femaleNum <= 0) {
                females.poll();
                continue;
            }
            if (maleNum == femaleNum) {
                males.pop();
                females.poll();
                countMatches++;
            } else if ( maleNum % 25 != 0 && femaleNum % 25 != 0) {
                females.poll();
                int currentValue = males.pop();
                males.push(currentValue - 2);
            }
            if (maleNum % 25 == 0) {
                males.pop();
                males.pop();
            }
            if (femaleNum % 25 == 0) {
                females.poll();
                females.poll();
            }

        }
        System.out.println(String.format("Matches: %s", countMatches));
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            int size = males.size();
            for (int i = 0; i < size - 1; i++) {
                System.out.print(males.pop() + ", ");
            }
            System.out.println(males.pop());
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            int size = females.size();
            for (int i = 0; i < size - 1; i++) {
                System.out.print(females.poll() +", ");
            }
            System.out.println(females.poll());
        }
    }
}


