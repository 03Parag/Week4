package com.Week4.Day02_Collection;
import java.util.*;

// Create SetConverter class to convert a Set to a Sorted List
class SetConverter {
    // Method to convert a Set into a sorted List
    public <T extends Comparable<T>> List<T> convertToSortedList(Set<T> set) {
        // Convert set to list
        List<T> sortedList = new ArrayList<>(set);
        // Sort the list in ascending order
        int n = sortedList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next
                if (sortedList.get(j).compareTo(sortedList.get(j + 1)) > 0) {
                    T temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }

    public static void main(String[] args) {
        // Create an instance of SetConverter
        SetConverter converter = new SetConverter();

        // Create an instance of a HashSet and add elements
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        // Convert to sorted list and print result
        System.out.println("Sorted List: " + converter.convertToSortedList(hashSet));
    }
}
