package com.Week4.Day05.JUnit.main;

import java.util.List;

// Create ListManager class to add, remove and get size of list
class ListManager {
    // Method to add element
    public void addElement(List<Integer> list, int element) {
        // If list is null
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        list.add(element);
    }

    // Method to remove element
    public void removeElement(List<Integer> list, int element) {
        // If list is null
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        list.remove(Integer.valueOf(element)); // Ensures element is removed by value, not index
    }

    // Method to get size
    public int getSize(List<Integer> list) {
        // If list is null
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        return list.size();
    }
}

