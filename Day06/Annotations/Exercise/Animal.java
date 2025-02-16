package com.Week4.Day06.Annotations.Exercise;

// Animal class (SuperClass)
class Animal {
    // Method to make sound
    void makeSound() {
        System.out.println("Animal make a sound");
    }
}

// Dog class (SubClass)
class Dog extends Animal {
    // Override the makeSound() method
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Sound {
    public static void main(String[] args) {
        // Create an instance animal
        Animal myDog = new Dog();

        // Call thr makeSound() method
        myDog.makeSound();
    }
}
