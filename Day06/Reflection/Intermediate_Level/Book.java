package com.Week4.Day06.Reflection.Intermediate_Level;
import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;

// Define the @Author annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Apply the @Author annotation to a class
@Author(name = "John Doe")
class Book {

}

// AnnotationRetriever class
class AnnotationRetriever {
    public static void main(String[] args) {
        try {
            // Get the Book class
            Class<?> clazz = Book.class;

            // Retrieve the @Author annotation
            Author author = clazz.getAnnotation(Author.class);

            // Check if annotation is present
            if (author != null) {
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

