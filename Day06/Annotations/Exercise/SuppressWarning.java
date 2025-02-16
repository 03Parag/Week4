package com.Week4.Day06.Annotations.Exercise;
import java.util.ArrayList;

// SuppressWarning class
class SuppressWarning {
    public static void main(String[] args) {
        // Suppressing the unchecked warning
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList();

        // Add the elements
        list.add("Java");
        list.add(42);

        // Get the element
        String element = (String) list.get(0);
        System.out.println("First element: " + element);
    }
}

