package com.nighthawk.spring_portfolio.mvc.fibonacci;

import java.util.Arrays;

public class FibonacciGenerator {

    // Method to generate Fibonacci array using iteration
    public static int[] generateFibonacciIterative(int n) {
        int[] fibonacciArray = new int[n];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        return fibonacciArray;
    }

    // Method to generate Fibonacci array using recursion
    public static int[] generateFibonacciRecursive(int n) {
        int[] fibonacciArray = new int[n];
        generateFibonacciRecursiveHelper(fibonacciArray, 0, n);
        return fibonacciArray;
    }

    private static void generateFibonacciRecursiveHelper(int[] fibonacciArray, int index, int n) {
        if (index < 2) {
            fibonacciArray[index] = index;
        } else {
            fibonacciArray[index] = fibonacciArray[index - 1] + fibonacciArray[index - 2];
        }

        if (index < n - 1) {
            generateFibonacciRecursiveHelper(fibonacciArray, index + 1, n);
        }
    }

    // Method to generate Fibonacci array using memoization
    public static int[] generateFibonacciMemoization(int n) {
        int[] fibonacciArray = new int[n];
        int[] memo = new int[n];
        generateFibonacciMemoizationHelper(fibonacciArray, memo, n - 1);
        return fibonacciArray;
    }

    private static int generateFibonacciMemoizationHelper(int[] fibonacciArray, int[] memo, int n) {
        if (n < 2) {
            fibonacciArray[n] = n;
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        fibonacciArray[n] = generateFibonacciMemoizationHelper(fibonacciArray, memo, n - 1)
                + generateFibonacciMemoizationHelper(fibonacciArray, memo, n - 2);

        memo[n] = fibonacciArray[n];

        return fibonacciArray[n];
    }

    // Main method to test the three ways of generating Fibonacci arrays
    public static void main(String[] args) {
        int n = 10;

        // Iterative
        int[] iterativeFibonacci = generateFibonacciIterative(n);
        System.out.println("Iterative Fibonacci: " + Arrays.toString(iterativeFibonacci));

        // Recursive
        int[] recursiveFibonacci = generateFibonacciRecursive(n);
        System.out.println("Recursive Fibonacci: " + Arrays.toString(recursiveFibonacci));

        // Memoization
        int[] memoizationFibonacci = generateFibonacciMemoization(n);
        System.out.println("Memoization Fibonacci: " + Arrays.toString(memoizationFibonacci));
    }
}

