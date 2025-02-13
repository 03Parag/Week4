package com.Week4.Day02_Collection;
import java.util.*;

// Create CompareSet to compare if two set are equal
class CompareSet {
    // Generic method to compare two sets
    public <T> boolean compareSets(Set<T> set1, Set<T> set2) {
        // Check if both sets are null or same, they are equal
        if (set1 == set2) {
            return true;
        }
        // If either set is null or sizes are different, they are not equal
        if (set1 == null || set2 == null || set1.size() != set2.size()) {
            return false;
        }
        // Compare sets directly
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        // Create an instance of CompareSet
        CompareSet setsCompare = new CompareSet();

        //Create an instance of Set 1 and add element
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        //Create an instance of Set 2 and add element
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Get the compareSets() method
        boolean areEqual = setsCompare.compareSets(set1, set2);
        // Print true
        System.out.println("Are the sets equal? " + areEqual);
    }
}

