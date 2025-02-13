package com.Week4.Day02_Collection;
import java.time.LocalDate;
import java.util.*;

// Create InsurancePolicy class representing an insurance policy with relevant details
class InsurancePolicy {
    // Attributes of InsurancePolicy
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor for InsurancePolicy
    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Method to get the policy number
    public String getPolicyNumber() {
        return policyNumber;
    }

    // Method to get the policy holder name
    public String getPolicyHolderName() {
        return policyHolderName;
    }

    // Method to get the expiry date of policy
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Method to get the coverage type
    public String getCoverageType() {
        return coverageType;
    }

    // Method to get the  premium amount
    public double getPremiumAmount() {
        return premiumAmount;
    }
}

// InsurancePolicyManagementSystem class
class InsurancePolicyManagementSystem {
    // Attributes of InsurancePolicyManagementSystem
    private Map<String, InsurancePolicy> policyMap;
    private Map<String, InsurancePolicy> orderedPolicies;
    private NavigableMap<LocalDate, InsurancePolicy> sortedPolicies;

    // Constructor for InsurancePolicyManagementSystem
    public InsurancePolicyManagementSystem() {
        this.policyMap = new HashMap<>();
        this.orderedPolicies = new LinkedHashMap<>();
        this.sortedPolicies = new TreeMap<>();
    }

    // Method to add the policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);
        sortedPolicies.put(policy.getExpiryDate(), policy);
    }

    // Method to get the policy by number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Method to get the policy that are expiring soon
    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate threshold = LocalDate.now().plusDays(days);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();

        // Identify policy that are expiring soon
        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicies.entrySet()) {
            if (entry.getKey().isBefore(threshold)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // Method to get the policy by holder
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();

        // Identify policy by holder
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    // Method to remove the expired policy
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<LocalDate> expiredKeys = new ArrayList<>();

        // Identify expired policies
        for (LocalDate date : sortedPolicies.keySet()) {
            if (date.isBefore(today)) {
                expiredKeys.add(date);
            }
        }

        // Remove expired policies
        for (LocalDate date : expiredKeys) {
            String policyNumber = sortedPolicies.get(date).getPolicyNumber();
            policyMap.remove(policyNumber);
            orderedPolicies.remove(policyNumber);
            sortedPolicies.remove(date);
        }
    }

    // Method to display policy
    public void displayPolicies() {
        for (InsurancePolicy policy : orderedPolicies.values()) {
            System.out.println(policy.getPolicyNumber() + " | " + policy.getPolicyHolderName() + " | " + policy.getExpiryDate());
        }
    }

    public static void main(String[] args) {
        // Create an instance of InsurancePolicyManagementSystem
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Add the policies
        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 800.0));
        system.addPolicy(new InsurancePolicy("P1003", "Alice", LocalDate.now().plusDays(5), "Home", 600.0));
        system.addPolicy(new InsurancePolicy("P1004", "Charlie", LocalDate.now().minusDays(5), "Health", 700.0));

        System.out.println("All Policies:");
        system.displayPolicies();

        // Get the policies expiring soon
        System.out.println("\nPolicies expiring within 30 days:");
        for (InsurancePolicy policy : system.getPoliciesExpiringSoon(30)) {
            System.out.println(policy.getPolicyNumber() + " | " + policy.getExpiryDate());
        }

        //Get the policy for holder
        System.out.println("\nPolicies for Alice:");
        for (InsurancePolicy policy : system.getPoliciesByHolder("Alice")) {
            System.out.println(policy.getPolicyNumber());
        }

        // Remove expired policy
        system.removeExpiredPolicies();
        System.out.println("\nAfter removing expired policies:");
        system.displayPolicies();
    }
}

