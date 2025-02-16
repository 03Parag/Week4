package com.Week4.Day06.Annotations.Beginner_Level;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Apply @Todo annotation to multiple methods
class ProjectModule {

    @Todo(task = "Implement authentication", assignedTo = "Alice", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Authentication logic here...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Database optimization logic here...");
    }

    @Todo(task = "Refactor payment module", assignedTo = "Charlie", priority = "CRITICAL")
    public void refactorPayments() {
        System.out.println("Payment module refactoring...");
    }

    public void completedFeature() {
        System.out.println("This feature is complete.");
    }
}

// Retrieve and print all @Todo annotations using Reflection API
class TodoAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the class containing annotated methods
            Class<?> clazz = ProjectModule.class;

            // Iterate over all declared methods
            for (Method method : clazz.getDeclaredMethods()) {
                // Check if the method has @Todo annotation
                if (method.isAnnotationPresent(Todo.class)) {
                    // Retrieve annotation details
                    Todo annotation = method.getAnnotation(Todo.class);
                    System.out.println("Pending Task: " + annotation.task());
                    System.out.println("Assigned To: " + annotation.assignedTo());
                    System.out.println("Priority: " + annotation.priority());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

