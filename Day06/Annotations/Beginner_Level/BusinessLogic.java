package com.Week4.Day06.Annotations.Beginner_Level;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Apply @ImportantMethod annotation to multiple methods
class BusinessLogic {

    @ImportantMethod(level = "CRITICAL")
    public void processPayments() {
        System.out.println("Processing payments...");
    }

    @ImportantMethod
    public void generateReports() {
        System.out.println("Generating reports...");
    }

    public void auxiliaryTask() {
        System.out.println("Performing auxiliary task...");
    }
}

// Retrieve and print all @ImportantMethod annotations using Reflection API
class ImportantMethodExample {
    public static void main(String[] args) {
        try {
            // Get the class containing the annotated methods
            Class<?> clazz = BusinessLogic.class;

            // Iterate over all declared methods
            for (Method method : clazz.getDeclaredMethods()) {
                // Check if the method has @ImportantMethod annotation
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    // Retrieve annotation details
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName());
                    System.out.println("Importance Level: " + annotation.level());
                    System.out.println("--------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
