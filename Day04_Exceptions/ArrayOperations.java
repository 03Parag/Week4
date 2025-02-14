package com.Week4.Day04_Exceptions;
import java.util.*;

// Create an ArrayOperations class to retrieve and print the value at index
class ArrayOperations {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        // Initialize the array
        Integer[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("Enter the index to retrieve: ");
            // Enter the index
            int index = input.nextInt();

            // Print the value at the index
            System.out.println("Value at index " +  index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index!");
        } catch (NullPointerException e) {
            System.err.println("Array is not initialized!");
        }

        // Close the scanner object
        input.close();
    }
}
