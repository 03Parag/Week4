package com.Week4.Day06.Reflection.Advanced_Level;
import java.lang.reflect.Field;
import java.util.Map;

// ObjectMapper class
class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Loop over fields in the class
            for (Field field : clazz.getDeclaredFields()) {
                // Get the field name
                String fieldName = field.getName();

                // Check if the map contains a value for this field
                if (properties.containsKey(fieldName)) {
                    // Make the field accessible if it's private
                    field.setAccessible(true);

                    // Get the value from the map
                    Object value = properties.get(fieldName);

                    // Set the field value after type checking
                    if (value != null && field.getType().isAssignableFrom(value.getClass())) {
                        field.set(instance, value);
                    } else {
                        System.out.println("Warning: Type mismatch for field '" + fieldName + "'");
                    }
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map object", e);
        }
    }
}

// User class
class User {
    private String name;
    private int age;
    private String email;

    // Override toString for output verification
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

// CustomObjectMapper class
class CustomObjectMapper {
    public static void main(String[] args) {
        // Define a property map
        Map<String, Object> properties = Map.of(
                "name", "Alice",
                "age", 25,
                "email", "alice@example.com"
        );

        // Convert map to User object
        User user = ObjectMapper.toObject(User.class, properties);

        // Print the mapped object
        System.out.println(user);
    }
}

