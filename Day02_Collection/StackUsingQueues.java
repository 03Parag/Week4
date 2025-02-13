package com.Week4.Day02_Collection;
import java.util.*;

// Create StackUsingQueues class to implement stack using queue
class StackUsingQueues {
    // Attributes of StackUsingQueues
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor for StackUsingQueues
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation for stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop operation for stack
    public int pop() {
        // If queue is empty throw exception
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // If queue size is more than 1 then remove element from queue 1 and add it in queue 2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // Last element removed
        int poppedElement = queue1.remove();

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    // Top operation for stack
    public int top() {
        // If queue is empty throw exception
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // If queue size is more than 1 then remove element from queue 1 and add it in queue 2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // Last element peeked
        int topElement = queue1.peek();

        // Move last element to queue2
        queue2.add(queue1.remove());

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if stack is empty (O(1))
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        // Create an instance of StackUsingQueues
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and display
        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.top());
    }
}

