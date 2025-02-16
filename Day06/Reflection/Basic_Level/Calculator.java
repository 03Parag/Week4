package com.Week4.Day06.Reflection.Basic_Level;
import java.lang.reflect.Method;

// Create the Calculator class with a private method 'multiply'
class Calculator {
    // Method to multiply two numbers
    private int multiply(int a, int b) {
        return a * b;
    }
}

// PrivateMethodInvoker class
class PrivateMethodInvoker {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the 'multiply' method using Reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Allow access to the private method
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments (5, 4)
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Print the result
            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

