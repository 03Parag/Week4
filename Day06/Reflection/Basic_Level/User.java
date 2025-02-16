package com.Week4.Day06.Reflection.Basic_Level;
import java.lang.reflect.*;
import java.util.Scanner;

// Create User class to inspect and display class details using Reflection
class User {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("Enter fully qualified class name: ");
        // Enter the class name
        String className = input.nextLine();

        try {
            // Load the class dynamically using Reflection
            Class<?> clazz = Class.forName(className);

            // Print the class name
            System.out.println("\nClass: " + clazz.getName());

            // Display declared fields (variables) of the class
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("  No fields found.");
            } else {
                for (Field field : fields) {
                    System.out.println("  " + field);
                }
            }

            // Display declared constructors of the class
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                System.out.println("  No constructors found.");
            } else {
                for (Constructor<?> constructor : constructors) {
                    System.out.println("  " + constructor);
                }
            }

            // Display declared methods of the class
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("  No methods found.");
            } else {
                for (Method method : methods) {
                    System.out.println("  " + method);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found! Please enter a valid class name.");
        }
            // Close the Scanner object
            input.close();

    }
}

