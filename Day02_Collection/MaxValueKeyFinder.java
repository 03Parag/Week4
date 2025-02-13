package com.Week4.Day02_Collection;
import java.util.*;

// Create MaxValueKeyFinder class to find the maximun value key in map
class MaxValueKeyFinder {
    // Method to find the key with the highest value
    public String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        // Initialize the max key with null
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Loop through the map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            // Update maxKey and maxValue if the current value is greater
            if (value > maxValue) {
                maxKey = key;
                maxValue = value;
            }
        }

        // Return the key with the highest value
        return maxKey;
    }

    public static void main(String[] args) {
        // Create an instance of map and put it in map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Create an instance of MaxValueKeyFinder
        MaxValueKeyFinder finder = new MaxValueKeyFinder();

        // Find and print the key with the highest value
        String maxKey = finder.findKeyWithMaxValue(inputMap);
        System.out.println("Key with the highest value: " + maxKey);
    }
}
