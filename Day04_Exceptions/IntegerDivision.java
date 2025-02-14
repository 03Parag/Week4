package com.Week4.Day04_Exceptions;
import java.util.*;

// Create IntegerDivision class to enter numerator and denominator and divide it and check for ArthmeticException
class IntegerDivision {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter  the numerator: ");
            // Enter the numerator
            int numerator = input.nextInt();

            System.out.println("Enter  the denominator: ");
            // Enter the denominator
            int denominator = input.nextInt();

            // Solve division
            int result = numerator / denominator;
            // Print the result
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by 0 is not allowed");
        } finally {
            System.out.println("Operation completed");

            // Close the scanner object
            input.close();
        }
    }
}
