package com.Week4.Day06.Annotations.Exercise;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    // Field for assigned person and priority
    String assignedTo();
    int priority();
}

// Apply @TaskInfo annotation to a method
class TaskManager {

    @TaskInfo(assignedTo = "Alice", priority = 1)
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

// Retrieve annotation details using Reflection API
class AnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> clazz = TaskManager.class;

            // Get the method with annotation
            Method method = clazz.getMethod("completeTask");

            // Check if @TaskInfo is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieve annotation details
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Assigned To: " + taskInfo.assignedTo());
                System.out.println("Task Priority: " + taskInfo.priority());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

