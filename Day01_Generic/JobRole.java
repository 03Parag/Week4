package com.Week4.Day01_Generic;
import java.util.*;

// JobRole (Abstract class)
abstract class JobRole {
    // Attributes of JobRole
    private String candidateName;
    private String skills;
    private int experienceYears;

    // Constructor for JobRole
    public JobRole(String candidateName, String skills, int experienceYears) {
        this.candidateName = candidateName;
        this.skills = skills;
        this.experienceYears = experienceYears;
    }

    // Method to get the candidate name
    public String getCandidateName() {
        return candidateName;
    }

    // Method to get the skills
    public String getSkills() {
        return skills;
    }

    // Method to get the experience year
    public int getExperienceYears() {
        return experienceYears;
    }

    // Abstract method to evaluate resume
    public abstract boolean evaluateResume();

    // Display resume details
    public void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Skills: " + skills);
        System.out.println("Experience: " + experienceYears + " years");
    }
}

// Software Engineer class (Subclass
class SoftwareEngineer extends JobRole {
    // Constructor for SoftwareEngineer
    public SoftwareEngineer(String candidateName, String skills, int experienceYears) {
        // Cali the constructor of JobRole
        super(candidateName, skills, experienceYears);
    }

    // Override the evaluateResume() method
    @Override
    public boolean evaluateResume() {
        return getSkills().contains("Java") && getExperienceYears() >= 2;
    }
}

// Data Scientist class (Subclass)
class DataScientist extends JobRole {
    // Constructor for DataScientist
    public DataScientist(String candidateName, String skills, int experienceYears) {
        // Cali the constructor of JobRole
        super(candidateName, skills, experienceYears);
    }

    // Override the evaluateResume() method
    @Override
    public boolean evaluateResume() {
        return getSkills().contains("Machine Learning") && getExperienceYears() >= 3;
    }
}

// Product Manager class (Subclass)
class ProductManager extends JobRole {
    // Constructor for ProductManager
    public ProductManager(String candidateName, String skills, int experienceYears) {
        // Cali the constructor of JobRole
        super(candidateName, skills, experienceYears);
    }

    // Override the evaluateResume() method
    @Override
    public boolean evaluateResume() {
        return getSkills().contains("Agile") && getExperienceYears() >= 4;
    }
}

// Generic Resume Processor
class Resume<T extends JobRole> {
    // Attributes of resume
    private List<T> candidates;

    // Constructor for resume
    public Resume() {
        this.candidates = new ArrayList<>();
    }

    // Method to add candidate's resume
    public void addCandidate(T candidate) {
        candidates.add(candidate);
    }

    // Method to get all candidates
    public List<T> getAllCandidates() {
        return new ArrayList<>(candidates);
    }
}

// Resume Screening Utility
class ResumeScreeningUtility {
    // Generic Wildcard Method to process resumes dynamically
    public static void processResumes(List<? extends JobRole> candidates) {
        for (JobRole candidate : candidates) {
            System.out.println("\n🔹 Screening Resume for: " + candidate.getCandidateName());
            candidate.displayResume();
            if (candidate.evaluateResume()) {
                System.out.println("Status: Shortlisted");
            } else {
                System.out.println("Status: Rejected");
            }
        }
    }
}

// Main Class
class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Create Resume instances for different job roles
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        Resume<ProductManager> productManagerResumes = new Resume<>();

        // Create candidates for each role
        softwareEngineerResumes.addCandidate(new SoftwareEngineer("Alice", "Java, Spring Boot, SQL", 3));
        softwareEngineerResumes.addCandidate(new SoftwareEngineer("Bob", "Python, JavaScript", 1));

        dataScientistResumes.addCandidate(new DataScientist("Charlie", "Machine Learning, Python, NLP", 4));
        dataScientistResumes.addCandidate(new DataScientist("Johnson", "Excel, Power BI", 2));

        productManagerResumes.addCandidate(new ProductManager("David", "Agile, Scrum, Leadership", 5));
        productManagerResumes.addCandidate(new ProductManager("Elizabeth", "Marketing, Data Analysis", 3));

        // Screening Process
        System.out.println("\nAI-Driven Resume Screening System\n");

        System.out.println("Screening Software Engineer Resumes:");
        ResumeScreeningUtility.processResumes(softwareEngineerResumes.getAllCandidates());

        System.out.println("\nScreening Data Scientist Resumes:");
        ResumeScreeningUtility.processResumes(dataScientistResumes.getAllCandidates());

        System.out.println("\nScreening Product Manager Resumes:");
        ResumeScreeningUtility.processResumes(productManagerResumes.getAllCandidates());
    }
}
