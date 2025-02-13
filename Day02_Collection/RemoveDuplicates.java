package com.Week4.Day02_Collection;
import java.util.*;

// Create RemoveDuplicates class to remove the duplicate
class RemoveDuplicates {
    // Generic method to remove duplicate elements
    public <T> ArrayList<T> duplicateRemoval(ArrayList<T> inputList) {

        // Create an instance of outputList
        ArrayList<T> outputList = new ArrayList<>();

        // Check if input list is null
        if (inputList == null) {
            return outputList;
        }

        // Loop through the input list and add elements to output list if they are not already present
        for (T element : inputList) {
            if (!outputList.contains(element)){
                outputList.add(element);
            }
        }
        return outputList;
    }

    public static void main(String[] args) {
        // Create an instance of inputList and add elements
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(3);
        inputList.add(1);
        inputList.add(2);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        // Print the inputList
        System.out.println("Input List: " + inputList);

        // Create an instance of RemoveDuplicates
        RemoveDuplicates removal = new RemoveDuplicates();
        // Call the generic duplicateRemoval() method
        ArrayList<Integer> outputList = removal.duplicateRemoval(inputList);
        // Print the outputList
        System.out.println("Output List: " + outputList);
    }
}
