package com.Week4.Day06.Reflection.Basic_Level;
import java.lang.reflect.Constructor;

// Create the Student class with constructors
class Student {
    // Attributes of Student
    private String name;
    private int age;

    // Default constructor for Student
    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    // Parameterized constructor for Student
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

// DynamicObjectCreation class
class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> studentClass = Class.forName("Student");

            // Create an instance using the default constructor
            Object student1 = studentClass.getDeclaredConstructor().newInstance();
            System.out.println("Object created using default constructor:");
            ((Student) student1).display();

            // Create an instance using the parameterized constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
            Object student2 = constructor.newInstance("John Doe", 22);

            System.out.println("\nObject created using parameterized constructor:");
            ((Student) student2).display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

