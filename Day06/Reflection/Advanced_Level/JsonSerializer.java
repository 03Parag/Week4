package com.Week4.Day06.Reflection.Advanced_Level;
import java.lang.reflect.Field;

// JsonSerializer class
class JsonSerializer {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = clazz.getDeclaredFields();
        int fieldCount = 0;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                // Append field as a JSON key-value pair
                json.append("\"").append(field.getName()).append("\":");

                // Format value correctly for JSON
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                fieldCount++;
                if (fieldCount < fields.length) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Person class
class Person {
    // Attributes of person
    private String name;
    private int age;
    private boolean isEmployed;

    // Constructor for person
    public Person(String name, int age, boolean isEmployed) {
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }
}
// JsonReflection class
class JsonReflection {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30, true);

        // Convert object to JSON-like string
        String json = JsonSerializer.toJson(person);

        // Print JSON output
        System.out.println(json);
    }
}

