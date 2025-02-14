package com.Week4.Day04_Exceptions;
import java.util.*;

// Create Division class to enter 2number and divide it and check for InputMismatchException and ArithmeticException
class Division {
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

            // Perfrom the division
            int result = numerator / denominator;
            // Print the result
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by 0 is not allowed");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input, enter numerical values only");
        }

        // Close the scanner object
        input.close();
    }
}
