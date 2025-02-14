package com.Week4.Day04_Exceptions;
import java.util.*;

// Define the InvalidAgeException class by extending exception
class InvalidAgeException extends Exception {

    // Constructor for InvalidAgeException
    public InvalidAgeException(String message) {
        super(message);
    }
}

class ageValidator {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        // If age is below 18 throw InvalidAgeException
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter your age>: ");
            // Enter the age
            int age = input.nextInt();

            // Get the method to validate to age
            validateAge(age);

        } catch (InvalidAgeException e) {
            System.err.println("Age must be 18 or above");
        }

        // Close the scanner object
        input.close();
    }
}
