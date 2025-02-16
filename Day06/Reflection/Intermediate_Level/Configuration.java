package com.Week4.Day06.Reflection.Intermediate_Level;
import java.lang.reflect.Field;

// Create the Configuration class with a private static field
class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    // Method to get API_KEY
    public static String getApiKey() {
        return API_KEY;
    }
}

// ModifyStaticField class
class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the Class object of Configuration
            Class<?> configClass = Configuration.class;

            // Get the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible for modification
            apiKeyField.setAccessible(true);

            // Modify the static field value
            apiKeyField.set(null, "NEW_SECURE_KEY");

            // Print the modified API_KEY
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

