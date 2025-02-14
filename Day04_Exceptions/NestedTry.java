package com.Week4.Day04_Exceptions;
import java.util.*;

// Create NestedTry class to take array a divisor and check for ArrayIndexOutOfBoundsException  andArithmeticException
class NestedTry {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        // Create an array of numbers
        int[] numbers = {11, 22 , 33, 44, 55, 66, 77, 88, 99};

        try {
            System.out.println("Enter the index: ");
            // Enter the index
            int index = input.nextInt();

            try {
                // Element of the given index
                int element = numbers[index];

                System.out.println("Enter divisor: ");
                // Enter the divisor
                int divisor = input.nextInt();

                // Perform the division
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.err.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid array index!");
        }

        // Close the scanner object
        input.close();
    }
}
