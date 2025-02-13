package com.Week4.Day02_Collection;
import java.util.*;

// Create FindSubset class to check if one set is a subset of another
public class FindSubset {
    // Method to check if set1 is a subset of set2
    public <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        // Check if either set is null
        if (set1 == null || set2 == null) {
            return false;
        }
        // Check if set2 contains all elements of set1
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        // Create an instance of set1 and add elements
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        // Create an instance of set2 and add elements
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Create an instance of FindSubset
        FindSubset find = new FindSubset();

        // Check if set1 is a subset of set2
        boolean result = find.isSubset(set1, set2);

        // Print the result
        System.out.println("Is set1 a subset of set2? " + result);  // Output: true
    }
}

