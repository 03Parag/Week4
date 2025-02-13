package com.Week4.Day02_Collection;
import java.util.*;

// Create SymmetricDifference class to find the symmetric difference of two sets
public class SymmetricDifference {
    // Method to find the symmetric difference of two sets
    public <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        // Create a new set with elements from set1 and add element of set2
        Set<T> difference = new HashSet<>(set1);
        difference.addAll(set2);
        // Create a new set with elements from set1 and retain element of set2
        Set<T> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        // Remove all elements in temp
        difference.removeAll(temp);
        return difference;
    }

    public static void main(String[] args) {
        // Create an instance of set1 and add elements
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Create an instance of set2 and add elements
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Create an instance of SymmetricDifference
        SymmetricDifference operations = new SymmetricDifference();

        // Create an instance of symmetric difference method
        Set<Integer> difference = operations.difference(set1, set2);

        // Print the result
        System.out.println("Symmetric Difference: " + difference);
    }
}

