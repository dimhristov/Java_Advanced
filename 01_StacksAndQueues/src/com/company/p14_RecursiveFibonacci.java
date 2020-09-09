package com.company;

import java.util.Scanner;

public class p14_RecursiveFibonacci {

    private static long[] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        memo = new long[n + 1];

        System.out.println(fib(n));
    }
    private static long fib(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib(n-1) + fib(n-2);
    }
}
