package com.Week4.Day06.Reflection.Intermediate_Level;
import java.lang.reflect.Method;
import java.util.Scanner;

// Create the MathOperations class with multiple public methods
class MathOperations {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }
}

// DynamicMethodInvoker class
class DynamicMethodInvoker {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            // Enter the method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = input.nextLine();

            // Enter the two numbers
            System.out.print("Enter first number: ");
            int num1 = input.nextInt();
            System.out.print("Enter second number: ");
            int num2 = input.nextInt();

            // Get the corresponding method dynamically using Reflection
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOps, num1, num2);

            // Print the result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Error: Invalid method name. Choose from (add, subtract, multiply).");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

