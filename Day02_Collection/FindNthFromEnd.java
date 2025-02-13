package com.Week4.Day02_Collection;
import java.util.*;

// Create FindNthFromEnd class to find an element from the end
class FindNthFromEnd {
    // Generic method to find the Nth element from the end
    public <T> T findNthElementFromEnd(LinkedList<T> linkedList, int N) {
        // If the linked list is null or n is negative or zero
        if (linkedList == null || N <= 0) {
            return null;
        }

        // Store the size of Linked List
        int size = linkedList.size();
        int targetIndex = size - N;

        // If the target index is negative
        if (targetIndex < 0) {
            return null;
        }
        return linkedList.get(targetIndex);
    }

    public static void main(String[] args) {
        // Create an instance of linkedList and add element
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        int N = 2;
        // Create an instance of FindNthFromEnd
        FindNthFromEnd find = new FindNthFromEnd();
        // Call the generic findNthElementFromEnd() method
        String nthFromEnd = find.findNthElementFromEnd(linkedList, N);
        // Print the nthFromEnd element
        System.out.println("The " + N + "th element from the end is: " + nthFromEnd);
    }
}
