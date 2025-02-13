package com.Week4.Day02_Collection;

// Create CircularBuffer class implement a circular buffer using queue
class CircularBuffer {
    // Attributes of CircularBuffer
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int capacity;


    // Constructor for CircularBuffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Insert element into the buffer
    public void enqueue(int value) {
        // Check if the size is equal to capacity then overwrite oldest
        if (size == capacity) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }
        buffer[rear] = value;
        // Move rear cyclically
        rear = (rear + 1) % capacity;
    }

    // Remove oldest element
    public int dequeue() {
        // If size is 0 throw exception
        if (size == 0) {
            throw new IllegalStateException("Buffer is empty");
        }
        int value = buffer[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create an instance of circular buffer
        CircularBuffer circularBuffer = new CircularBuffer(3);

        // Enqueue the element and display it
        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        circularBuffer.enqueue(3);
        circularBuffer.display();

        circularBuffer.enqueue(4);
        circularBuffer.display();

        // Dequeue the element and display it
        circularBuffer.dequeue();
        circularBuffer.display();
    }
}

