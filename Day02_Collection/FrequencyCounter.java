package com.Week4.Day02_Collection;
import java.util.*;

// Create FrequencyCounter class to count the frequency of each element
class FrequencyCounter {
    // Generic method to count the Frequency of an element in an arraylist
    public <T> Map<T, Integer> countFrequency(ArrayList<T> arrayList) {
        Map<T, Integer> frequencyMap = new HashMap<>();

        // Check if input list is null
        if (arrayList == null) {
            return frequencyMap;
        }

        // Loop through the list and update the frequency map
        for (T item : arrayList) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        // Create an instance of FrequencyCounter
        FrequencyCounter frequencyCounter = new FrequencyCounter();

        // Create an ArrayList and add elements
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("apple");
        arrayList.add("orange");

        // Get the frequency map
        Map<String, Integer> result = frequencyCounter.countFrequency(arrayList);

        // Print the result
        System.out.println("Frequency of element: " + result);
    }
}
