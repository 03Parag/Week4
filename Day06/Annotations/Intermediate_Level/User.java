package com.Week4.Day06.Annotations.Intermediate_Level;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Create the User class with @MaxLength annotation
class User {
    @MaxLength(10)
    private String username;

    // Constructor for user
    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    private void validateMaxLength(Object obj, String fieldValue) {
        try {
            // Get the declared fields of the class
            for (Field field : obj.getClass().getDeclaredFields()) {
                // Check if the field has @MaxLength annotation
                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = field.getAnnotation(MaxLength.class);
                    int maxLength = annotation.value();

                    // Validate the length
                    if (fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException(
                                "Field '" + field.getName() + "' exceeds max length of " + maxLength + " characters."
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Test the @MaxLength annotation
class MaxLengthExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe");
            System.out.println("User created with username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername");
            System.out.println("User created with username: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

