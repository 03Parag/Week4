package com.Week4.Day02_Collection;
import java.util.*;

// Create MergeMaps class to merge two maps
class MergeMaps {
    // Method to merge two maps
    public Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create an instance of map
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        // Loop through the second map and merge it with the first map
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // If the key exists in the merged map, sum the values; otherwise, add the key-value pair
            mergedMap.merge(key, value, Integer::sum);
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        // Create the first map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Create the second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Create an instance of MergeMaps
        MergeMaps mergeMapsInstance = new MergeMaps();

        // Merge the two maps
        Map<String, Integer> mergedMap = mergeMapsInstance.mergeMaps(map1, map2);

        // Print the merged map
        System.out.println("Merged Map: " + mergedMap);
    }
}

