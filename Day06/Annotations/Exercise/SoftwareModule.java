package com.Week4.Day06.Annotations.Exercise;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define a containing annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
    String reportedBy();
}

// Apply the @BugReport annotation multiple times
class SoftwareModule {

    @BugReport(description = "Null pointer exception in edge cases", reportedBy = "Alice")
    @BugReport(description = "Performance issue on large inputs", reportedBy = "Bob")
    public void processData() {
        System.out.println("Processing data");
    }
}

// Retrieve all @BugReport annotations using Reflection API
class RepeatableAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the class containing the annotated method
            Class<?> clazz = SoftwareModule.class;

            // Get the method
            Method method = clazz.getMethod("processData");

            // Retrieve multiple @BugReport annotations
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

            // Print all bug reports
            for (BugReport bug : bugReports) {
                System.out.println("Bug Description: " + bug.description());
                System.out.println("Reported By: " + bug.reportedBy());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

