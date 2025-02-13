package com.Week4.Day02_Collection;
import java.util.*;

// Create SetOperations class for union and intersection of two sets
class SetOperations {
    // Method to find the union of two sets
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        // Create a new set with elements from set1 and add all element of another set
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    // Method to find the intersection of two sets
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        // Create a new set with elements from set1 and retain all element of another set
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        // Create an instance of SetOperations
        SetOperations operations = new SetOperations();

        //Create an instance of Set 1 and add element
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        //Create an instance of Set 2 and add element
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Create an instance of union and intersection methods
        Set<Integer> unionSet = operations.union(set1, set2);
        Set<Integer> intersectionSet = operations.intersection(set1, set2);

        // Print the union and intersection
        System.out.println("Union: " + unionSet);  // Output: Union: [1, 2, 3, 4, 5]
        System.out.println("Intersection: " + intersectionSet);
    }
}

