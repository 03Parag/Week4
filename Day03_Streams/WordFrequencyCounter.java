package com.Week4.Day03_Streams;
import  java.io.*;
import java.util.*;

// Create a WordFrequencyCounter class to count the frequency of top 5 words in a file
class WordFrequencyCounter {
    // Attributes of WordFrequencyCounter
    private final String filePath;

    // Constructor for WordFrequencyCounter
    WordFrequencyCounter(String filePath) {
        this.filePath = filePath;
    }

    // Method to count and display top 5 words in a file
    public void CountWordsAndDisplayTop5() {
        // Create an instance of HashMap
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Create an instance of BufferedReader object
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", " ").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Convert map to a list and sort by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display total word count
        int totalWords = wordCountMap.values().stream().mapToInt(Integer :: intValue).sum();
        System.out.println("Total words: " + totalWords);
        // Display top 5 words
        System.out.println("\nTop 5 most frequent words: ");
        for (int i = 0; i < 5 && i < sortedWords.size(); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/com/Week4/Day03/WordFrequencyCounter.java";

        // Create an instance of WordFrequencyCounter object
        WordFrequencyCounter counter = new WordFrequencyCounter(filePath);

        // Get the CountWordsAndDisplayTop5 method
        counter.CountWordsAndDisplayTop5();
    }
}
