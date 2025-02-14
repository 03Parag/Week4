package com.Week4.Day04_Exceptions;

// Create ExceptionPropagation class to propagate exception from the class
class ExceptionPropagation {
    // Create method1
    public void method1() throws ArithmeticException {
        System.out.println("Executing method1!");
        int result = 1 / 0;
    }

    // Create method2
    public void method2() throws ArithmeticException {
        System.out.println("Executing method2!");
        // Call the method1
        method1();
    }

    public static void main(String[] args) {
        // Creste an instance of ExceptionPropagation
        ExceptionPropagation exceptionPropagation = new ExceptionPropagation();

        try {
            exceptionPropagation.method2();
        } catch (ArithmeticException e) {
            System.err.println("Handled exception in main");
        }
    }
}
