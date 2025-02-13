package com.Week4.Day02_Collection;
import java.util.*;

// Create ReverseList class to reverse the elements of a given List without using built-in reverse methods
class ReverseList {
    // Method to reverse an ArrayList using 2 pointer approach
    public <T> void reverseArrayList(ArrayList<T> arrayList) {
        // If list is null return
        if (arrayList == null) {
            return;
        }

        // Initialize left to 0 and right size of list
        int left = 0, right = arrayList.size() - 1;
        // If left is less than right
        while (left < right) {
            // Swap elements
            T temp = arrayList.get(left);
            arrayList.set(left, arrayList.get(right));
            arrayList.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList using 2 pointer approach
    public <T> void reverseLinkedList(LinkedList<T> linkedList) {
        // If list is null return
        if (linkedList == null) {
            return;
        }
        // Initialize left to 0 and right size of list
        int left = 0, right = linkedList.size() - 1;
        // If left is less than right
        while (left < right) {
            // Swap elements
            T temp = linkedList.get(left);
            linkedList.set(left, linkedList.get(right));
            linkedList.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Create an instance of reverse list
        ReverseList reverseList = new ReverseList();

        // Create an ArrayList and add element
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        // Get the reverseArrayList() method
        reverseList.reverseArrayList(arrayList);
        // Print the arraylist
        System.out.println("Reversed ArrayList: " + arrayList);

        // Create a LinkedList and add element
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        // Get the reverseLinkedList() method
        reverseList.reverseLinkedList(linkedList);
        // Print the linkedlist
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
