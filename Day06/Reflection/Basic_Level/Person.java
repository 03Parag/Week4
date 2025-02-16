package com.Week4.Day06.Reflection.Basic_Level;
import java.lang.reflect.Field;

// Create Person class with a private field 'age'
class Person {
    // Attributes of age
    private int age;

    // Constructor to initialize age
    public Person(int age) {
        this.age = age;
    }

    // Method to display current age
    public void showAge() {
        System.out.println("Current Age: " + age);
    }
}

class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Display the initial age
            person.showAge();

            // Get the 'age' field
            Field ageField = Person.class.getDeclaredField("age");

            // Allow access to private field
            ageField.setAccessible(true);

            // Modify the private field 'age' dynamically
            ageField.set(person, 30);

            // Retrieve the modified field value
            int modifiedAge = (int) ageField.get(person);

            // Print the modified value
            System.out.println("Modified Age: " + modifiedAge);

            // Display the updated age using the method
            person.showAge();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

