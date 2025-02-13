package com.Week4.Day02_Collection;
import java.util.*;

// Create InvertMap class invert a map<k, v> to map<v, k>
class InvertMap {
    // Method to invert a map
    public <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        // Create an inverted map
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Loop through the input map
        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the inverted map does not contain the value, add it with a new list
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }

            // Add the key to the list corresponding to the value in the inverted map
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        // Create an instance of InvertMap
        InvertMap invertMapInstance = new InvertMap();

        // Create the input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Print the input map
        System.out.println("Input Map: " + inputMap);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMapInstance.invertMap(inputMap);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);  // Output: {1=[A, C], 2=[B]}
    }
}
