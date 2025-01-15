package com.yaksha.assignment;

public class WhileLoopAssignment {

    public static void main(String[] args) {

        // Task 1: Print numbers from 1 to N
        int N = 5;
        System.out.print("Numbers from 1 to " + N + ": ");
        int i = 1;
        while (i <= N) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // Task 2: Sum of first N natural numbers
        int sum = 0;
        i = 1;
        while (i <= N) {
            sum += i;
            i++;
        }
        System.out.println("Sum of first " + N + " natural numbers: " + sum);

        // Task 3: Factorial of a number N
        int number = 5;
        int factorial = 1;
        i = 1;
        while (i <= number) {
            factorial *= i;
            i++;
        }
        System.out.println("Factorial of " + number + ": " + factorial);

        // Task 4: Count down from N to 1
        System.out.print("Count down from " + N + ": ");
        i = N;
        while (i >= 1) {
            System.out.print(i + " ");
            i--;
        }
        System.out.println();

        // Task 5: Print Fibonacci sequence up to N terms
        int first = 0, second = 1;
        System.out.print("Fibonacci sequence up to " + N + " terms: ");
        i = 1;
        while (i <= N) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
            i++;
        }
        System.out.println();
    }
}
