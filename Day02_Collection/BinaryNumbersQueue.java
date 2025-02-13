package com.Week4.Day02_Collection;
import java.util.*;

// Create BinaryNumbersQueue class to generate binary number queue
class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        // Create an instance of arraylist and linkedlist
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.add("1");

        for (int i = 0; i < N; i++) {
            // Remove the front element
            String binary = queue.remove();
            result.add(binary);

            // Add next binary numbers
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        // Enter the number of binary number
        int N = 5;
        // Get the generateBinaryNumbers() method
        List<String> binaryNumbers = generateBinaryNumbers(N);
        // Print the binary number
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}

