package com.Week4.Day06.Reflection.Advanced_Level;
import java.lang.reflect.Method;

// ArithmeticOperations class
class ArithmeticOperations {
    // Method to add the numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to multiply the numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    public void simulateHeavyComputation() {
        try {
            Thread.sleep(500); // Simulating a heavy task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// ExecutionTimer class
class ExecutionTimer {
    public static void invokeAndMeasure(Object obj, String methodName, Object... args) {
        try {
            // Get all methods of the class
            Method[] methods = obj.getClass().getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    long startTime = System.nanoTime(); // Start timing

                    // Invoke method dynamically
                    Object result = method.invoke(obj, args);

                    long endTime = System.nanoTime(); // End timing
                    long duration = endTime - startTime;

                    // Print execution time and result
                    System.out.println("Method: " + methodName);
                    System.out.println("Execution Time: " + duration + " nanoseconds");

                    if (method.getReturnType() != void.class) {
                        System.out.println("Result: " + result);
                    }
                    return;
                }
            }
            System.out.println("Method '" + methodName + "' not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// MethodExecutionTimer class
class MethodExecutionTimer {
    public static void main(String[] args) {
        // Create an  instance of ArithmeticOperations
        ArithmeticOperations operations = new ArithmeticOperations();

        // Measure execution time for different methods
        ExecutionTimer.invokeAndMeasure(operations, "add", 5, 10);
        ExecutionTimer.invokeAndMeasure(operations, "multiply", 3, 4);
        ExecutionTimer.invokeAndMeasure(operations, "simulateHeavyComputation");
    }
}

