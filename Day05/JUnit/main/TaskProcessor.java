package com.Week4.Day05.JUnit.main;

// Create TaskProcessor class to make a method that sleeps for 3 sec before returning the result
class TaskProcessor {
    // Method to make task run long
    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

