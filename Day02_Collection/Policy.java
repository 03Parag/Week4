package com.Week4.Day02_Collection;
import java.time.LocalDate;
import java.util.*;

// Policy class representing an insurance policy with relevant details
class Policy implements Comparable<Policy> {
    // Attributes of  Policy
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor for Policy
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Method to get the policy number
    public String getPolicyNumber() {
        return policyNumber;
    }

    // Method to get the expiry date
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Method to get the coverage type
    public String getCoverageType() {
        return coverageType;
    }

    // Method to find the object is equal
    public boolean equals(Object obj) {
        // If this object is equal return true
        if (this == obj)
            return true;
        // If object is null or not equal return false
        if (obj == null || getClass() != obj.getClass())
            return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    // Method to get the hashcode
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Method to compare expiry dates
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

 // InsurancePolicyManager class to manage different types of policy sets.
class InsurancePolicyManager {
    // Attributes of InsurancePolicyManager
    private Set<Policy> hashSetPolicies;
    private Set<Policy> linkedHashSetPolicies;
    private Set<Policy> treeSetPolicies;

    // Constructor for InsurancePolicyManager
    public InsurancePolicyManager() {
        this.hashSetPolicies = new HashSet<>();
        this.linkedHashSetPolicies = new LinkedHashSet<>();
        this.treeSetPolicies = new TreeSet<>();
    }

    // Adds a policy to all three sets.
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieves all unique policies.
    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet): " + hashSetPolicies);
    }

    // Retrieves policies expiring within the next 30 days.
    public List<Policy> getExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<Policy> expiringPolicies = new ArrayList<>();

        for (Policy policy : treeSetPolicies) {
            if (!policy.getExpiryDate().isAfter(threshold)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Retrieves policies with a specific coverage type.
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> filteredPolicies = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Identifies duplicate policies based on policy numbers.
    public Set<String> getDuplicatePolicyNumbers() {
        Map<String, Integer> policyCount = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    // Compares the performance of HashSet, LinkedHashSet, and TreeSet.
    public void comparePerformance() {
        final int TEST_SIZE = 100000;
        List<Policy> testPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // Generate test policies
        for (int i = 1; i <= TEST_SIZE; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, today.plusDays(i), "Auto", i * 100.0));
        }

        // Measure HashSet performance
        long start = System.nanoTime();
        Set<Policy> testHashSet = new HashSet<>(testPolicies);
        long hashSetTime = System.nanoTime() - start;

        // Measure LinkedHashSet performance
        start = System.nanoTime();
        Set<Policy> testLinkedHashSet = new LinkedHashSet<>(testPolicies);
        long linkedHashSetTime = System.nanoTime() - start;

        // Measure TreeSet performance
        start = System.nanoTime();
        Set<Policy> testTreeSet = new TreeSet<>(testPolicies);
        long treeSetTime = System.nanoTime() - start;

        // Display results
        System.out.println("Performance Comparison:");
        System.out.println("HashSet Time: " + hashSetTime + " ns");
        System.out.println("LinkedHashSet Time: " + linkedHashSetTime + " ns");
        System.out.println("TreeSet Time: " + treeSetTime + " ns");
    }
}

// Main class
class InsurancePolicySystem {
    public static void main(String[] args) {
        // Create an instance of InsurancePolicyManager
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Create policies
        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 700.0);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 600.0);
        Policy p4 = new Policy("P004", "David", LocalDate.now().plusDays(5), "Health", 400.0);
        Policy p5 = new Policy("P005", "Eve", LocalDate.now().plusDays(15), "Auto", 800.0);

        // Adding policies
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);
        manager.addPolicy(p5);

        // Display all policies
        manager.displayAllPolicies();

        // Display policies expiring soon
        System.out.println("Policies expiring soon: " + manager.getExpiringSoonPolicies());

        // Retrieve policies by coverage type
        System.out.println("Auto Insurance Policies: " + manager.getPoliciesByCoverageType("Auto"));

        // Find duplicate policies
        System.out.println("Duplicate Policy Numbers: " + manager.getDuplicatePolicyNumbers());

        // Performance Comparison
        manager.comparePerformance();
    }
}
