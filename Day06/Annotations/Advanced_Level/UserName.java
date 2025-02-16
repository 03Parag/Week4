package com.Week4.Day06.Annotations.Advanced_Level;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Define a UserName class with @JsonField annotations
class UserName {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    // Constructor for username
    public UserName(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

// Implement JSON Serialization Handler
class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                try {
                    Object value = field.get(obj);
                    if (!firstField) {
                        jsonBuilder.append(", ");
                    }
                    jsonBuilder.append("\"").append(jsonKey).append("\": ");

                    // Handle different data types
                    if (value instanceof String) {
                        jsonBuilder.append("\"").append(value).append("\"");
                    } else {
                        jsonBuilder.append(value);
                    }
                    firstField = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

// Test JSON Serialization
class CustomJsonAnnotationExample {
    public static void main(String[] args) {
        UserName user = new UserName("Alice", 25, "alice@example.com");
        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}

