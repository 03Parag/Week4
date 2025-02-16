package com.Week4.Day06.Annotations.Intermediate_Level;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Create a utility to measure execution time
class ExecutionTimer {
    public static void invokeWithTiming(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                double startTime = System.nanoTime();
                method.invoke(obj);
                double endTime = System.nanoTime();

                double durationTime = (endTime - startTime) / 1_000_000.0;
                System.out.println("Execution Time of " + methodName + ": " + durationTime + " ms");
            } else {
                System.out.println("Method " + methodName + " is not annotated with @LogExecutionTime.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Apply @LogExecutionTime annotation to methods
class TaskProcessor {

    @LogExecutionTime
    public void fastTask() {
        System.out.println("Executing fast task...");
    }

    @LogExecutionTime
    public void slowTask() {
        System.out.println("Executing slow task...");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("This is a normal task without logging.");
    }
}

// Test the annotation and execution time measurement
class LogExecutionTimeExample {
    public static void main(String[] args) {
        TaskProcessor taskProcessor = new TaskProcessor();

        // Measure execution time for annotated methods
        ExecutionTimer.invokeWithTiming(taskProcessor, "fastTask");
        ExecutionTimer.invokeWithTiming(taskProcessor, "slowTask");

        // Attempting to measure a method that is not annotated
        ExecutionTimer.invokeWithTiming(taskProcessor, "normalTask");
    }
}

