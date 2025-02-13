package com.Week4.Day01_Generic;
import java.util.*;

// CourseType class (Abstract)
abstract class CourseType {
    // Attributes of CourseType
    private String courseName;
    private String instructor;

    // Constructor for CourseType
    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Method to get the course name
    public String getCourseName() {
        return courseName;
    }

    // Method to get the instructor
    public String getInstructor() {
        return instructor;
    }

    // Abstract method to evaluate course type
    public abstract void evaluate();
}

// ExamCourse class (Subclass)
class ExamCourse extends CourseType {
    // Attributes of ExamCourse
    private int examWeightage;

    // Constructor for ExamCourse
    public ExamCourse(String courseName, String instructor, int examWeightage) {
        // Call the constructor of CourseType
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }

    // Method to get the weightage of exam
    public int getExamWeightage() {
        return examWeightage;
    }

    // Override the evaluate method for ExamCourse
    @Override
    public void evaluate() {
        System.out.println("Evaluation for " + getCourseName() + " is Exam-Based with " + examWeightage + "% weightage.");
    }
}

// AssignmentCourse (Subclass)
class AssignmentCourse extends CourseType {
    // Attributes of AssignmentCourse
    private int assignmentCount;

    // Constructor for AssignmentCourse
    public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
        // Call the constructor of CourseType
        super(courseName, instructor);
        this.assignmentCount = assignmentCount;
    }

    // Method to get the assignment count
    public int getAssignmentCount() {
        return assignmentCount;
    }

    // Override the evaluate method for AssignmentCourse
    @Override
    public void evaluate() {
        System.out.println("Evaluation for " + getCourseName() + " is Assignment-Based with " + assignmentCount + " assignments.");
    }
}

// ResearchCourse (Subclass)
class ResearchCourse extends CourseType {
    // Attributes of ResearchCourse
    private String researchTopic;

    // Constructor for ResearchCourse
    public ResearchCourse(String courseName, String instructor, String researchTopic) {
        // Call the constructor of CourseType
        super(courseName, instructor);
        this.researchTopic = researchTopic;
    }

    // Method to get the topic of research
    public String getResearchTopic() {
        return researchTopic;
    }

    // Override the evaluate method for ResearchCourse
    @Override
    public void evaluate() {
        System.out.println("Evaluation for " + getCourseName() + " is Research-Based on topic: " + researchTopic);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    // Attributes of course
    private List<T> courses;

    // Constructor for course
    public Course() {
        this.courses = new ArrayList<>();
    }

    // Method to add the course
    public void addCourse(T course) {
        courses.add(course);
    }

    // Method to get the list of courses
    public List<T> getCourses() {
        return new ArrayList<>(courses);
    }

    // Method to display courses
    public void displayCourses() {
        for (T course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Instructor: " + course.getInstructor());
            course.evaluate();
        }
    }
}

// Course Utility (handle any type of Course)
class CourseUtility {
    // Method to display all courses
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Instructor: " + course.getInstructor());
            course.evaluate();
        }
    }
}

// Main Class
class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        // Create Course instance for each type
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Create Courses of each type
        ExamCourse math101 = new ExamCourse("Mathematics 101", "Dr. Smithson", 70);
        ExamCourse cs201 = new ExamCourse("Computer Science 201", "Dr. Johnson", 80);

        AssignmentCourse eng102 = new AssignmentCourse("English  102", "Prof. Eliza", 5);
        AssignmentCourse hist205 = new AssignmentCourse("History 205", "Dr. Dukeson", 6);

        ResearchCourse aiResearch = new ResearchCourse("AI Research", "Dr. Alice", "Machine Learning");
        ResearchCourse bioResearch = new ResearchCourse("Biotech Research", "Dr. Bob", "Genetic Engineering");

        // Add courses to respective lists
        examCourses.addCourse(math101);
        examCourses.addCourse(cs201);

        assignmentCourses.addCourse(eng102);
        assignmentCourses.addCourse(hist205);

        researchCourses.addCourse(aiResearch);
        researchCourses.addCourse(bioResearch);

        // Display Courses
        System.out.println(" Exam-Based Courses:");
        examCourses.displayCourses();

        System.out.println("\n Assignment-Based Courses:");
        assignmentCourses.displayCourses();

        System.out.println("\n Research-Based Courses:");
        researchCourses.displayCourses();

        // Display all courses
        System.out.println("\n All Courses:");
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math101);
        allCourses.add(cs201);
        allCourses.add(eng102);
        allCourses.add(hist205);
        allCourses.add(aiResearch);
        allCourses.add(bioResearch);

        CourseUtility.displayAllCourses(allCourses);
    }
}
