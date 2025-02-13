package com.Week4.Day02_Collection;
import java.util.*;

// Create ReverseQueue class to reverse the queue by using queue operation only
class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        // Check if the queue is empty
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.remove();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element back to the rear
        queue.add(front);
    }

    public static void main(String[] args) {
        // Create an instance of queue and add element
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Print the original queue
        System.out.println("Original Queue: " + queue);
        // Get the reverseQueue() method
        reverseQueue(queue);
        // Print the  reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
