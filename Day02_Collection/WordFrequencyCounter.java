package com.Week4.Day02_Collection;
import java.io.*;
import java.util.*;
// Create WordFrequencyCounter class to count the frequency of word using hashmap
class WordFrequencyCounter {

    // Method to count the frequency of each word in the file
    public static Map<String, Integer> countWordFrequency(String filePath) {
        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();
        // Try with resources to ensure the file is closed after reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                // Split the line into words
                String[] words = line.split("\\s+");

                // Count each word
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    // Update the word count in the HashMap
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the word count map
        return wordCountMap;
    }

    public static void main(String[] args) {
        // Path to the input file
        String filePath = "src/com/Week4/Day02/WordFrequencyCounter.java";

        // Get the count word frequency method
        Map<String, Integer> wordFrequency = countWordFrequency(filePath);

        // Print the word frequencies
        if (wordFrequency != null) {
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}

