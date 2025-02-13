package com.Week4.Day02_Collection;
import java.util.*;

// Create VotingSystem class to store, display in sorted order and maintain the order if list
class VotingSystem {
    // Attributes of VotingSystem
    private Map<String, Integer> voteCountMap;
    private LinkedHashMap<String, Integer> voteOrderMap;
    private TreeMap<String, Integer> sortedResultsMap;

    // Constructor for VotingSystem
    public VotingSystem() {
        this.voteCountMap = new HashMap<>();
        this.voteOrderMap = new LinkedHashMap<>();
        this.sortedResultsMap = new TreeMap<>();
    }

    // Method to cast vote
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteCountMap.get(candidate));
        sortedResultsMap.put(candidate, voteCountMap.get(candidate));
    }

    // Method to display vote count
    public void displayVoteCounts() {
        System.out.println("Vote Counts (Unordered - HashMap):");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Method to display vote order
    public void displayVoteOrder() {
        System.out.println("\nVote Order (LinkedHashMap - Insertion Order):");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Method to display sorted result
    public void displaySortedResults() {
        System.out.println("\nSorted Results (TreeMap - Alphabetical Order):");
        for (Map.Entry<String, Integer> entry : sortedResultsMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Create an instance of VotingSystem
        VotingSystem votingSystem = new VotingSystem();

        // Get the vote cast method
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Get the dispay vote count method
        votingSystem.displayVoteCounts();
        votingSystem.displayVoteOrder();
        votingSystem.displaySortedResults();
    }
}

