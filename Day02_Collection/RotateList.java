package com.Week4.Day02_Collection;
import java.util.*;

// Create RotateList class to rotate the element of a list
class RotateList {
    // Method to rotate a list by k positions
    public <T> void rotateList(ArrayList<T> arrayList, int k) {
        // If the arrayList is null or is empty or position(k) is negative or zero
        if (arrayList == null || arrayList.isEmpty() || k <= 0) {
            return;
        }

        // Store the size of arrayList
        int size = arrayList.size();
        // Handle cases where k > size
        k = k % size;

        // Reverse the first part (0 to k-1)
        reverseSublist(arrayList, 0, k - 1);

        // Reverse the second part (k to end)
        reverseSublist(arrayList, k, size - 1);

        // Reverse the whole arrayList
        reverseSublist(arrayList, 0, size - 1);
    }

    // Method to reverse a portion of the arrayList
    private <T> void reverseSublist (ArrayList<T> arrayList, int start, int end) {
        // If start is less than end
        while (start < end) {
            // Swap the element
            T temp = arrayList.get(start);
            arrayList.set(start, arrayList.get(end));
            arrayList.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Create an instance of RotateList
        RotateList rotateList = new RotateList();

        // Create a arrayList and add element
        ArrayList<Integer> arrayList = new ArrayList<>();
        int rotateBy = 2;
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        // Rotate the arrayList
        rotateList.rotateList(arrayList, rotateBy);

        // Print the arrayList
        System.out.println("Rotated List: " + arrayList);
    }
}
