package com.Week4.Day02_Collection;
import java.util.*;

// Patient class contain information of the patient
class Patient {
    // Attributes of Patient
    private String name;
    private int severity;

    // Constructor for patient
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Method to get the name
    public String getName() {
        return name;
    }

    // Method to get the severity
    public int getSeverity() {
        return severity;
    }
}

// Main class
class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create an instance of PriorityQueue
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity()));

        // Adding patients
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        // Processing patients based on severity
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.poll();
            System.out.println("Patient: " + patient.getName() + " (Severity: " + patient.getSeverity() + ")");
        }
    }
}

