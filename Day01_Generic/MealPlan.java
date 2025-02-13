package com.Week4.Day01_Generic;
import java.util.*;

// MealPlan (Interface)
interface MealPlan {
    String getMealName();
    void showMealDetails();
}

// Vegetarian Meal (Implements MealPlan)
class VegetarianMeal implements MealPlan {
    // Attributes of VegetarianMeal
    private String mealName;

    // Constructor for VegetarianMeal
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    // Override the getMealName() method
    @Override
    public String getMealName() {
        return mealName;
    }

    // Override the showMealDetails() method
    @Override
    public void showMealDetails() {
        System.out.println("Vegetarian Meal: " + mealName);
    }
}

// Vegan Meal (Implements MealPlan)
class VeganMeal implements MealPlan {
    // Attributes of VeganMeal
    private String mealName;

    // Constructor for VeganMeal
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    // Override the getMealName() method
    @Override
    public String getMealName() {
        return mealName;
    }

    // Override the showMealDetails() method
    @Override
    public void showMealDetails() {
        System.out.println("Vegan Meal: " + mealName);
    }
}

// Keto Meal (Implements MealPlan)
class KetoMeal implements MealPlan {
    // Attributes of KetoMeal
    private String mealName;

    // Constructor for KetoMeal
    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    // Override the getMealName() method
    @Override
    public String getMealName() {
        return mealName;
    }

    // Override the showMealDetails() method
    @Override
    public void showMealDetails() {
        System.out.println("Keto Meal: " + mealName);
    }
}

// High-Protein Meal (Implements MealPlan)
class HighProteinMeal implements MealPlan {
    // Attributes of HighProteinMeal
    private String mealName;

    // Constructor for HighProteinMeal
    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    // Override the getMealName() method
    @Override
    public String getMealName() {
        return mealName;
    }

    // Override the showMealDetails() method
    @Override
    public void showMealDetails() {
        System.out.println("High-Protein Meal: " + mealName);
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    // Attributes of Meal
    private List<T> meals;

    // Constructor for Meal
    public Meal() {
        this.meals = new ArrayList<>();
    }

    // Method to add meal
    public void addMeal(T meal) {
        meals.add(meal);
    }

    // Method to get the list of meals
    public List<T> getMeals() {
        return new ArrayList<>(meals);
    }

    // Method to display meal details
    public void displayMeals() {
        for (T meal : meals) {
            meal.showMealDetails();
        }
    }
}

// Meal Utility Class
class MealUtility {
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("\nGenerating Personalized Meal Plan");
        meal.showMealDetails();
        System.out.println("Meal Plan Successfully Created");
    }
}

// Main Class
class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Create Meal instances for each type
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        Meal<VeganMeal> veganMeals = new Meal<>();
        Meal<KetoMeal> ketoMeals = new Meal<>();
        Meal<HighProteinMeal> highProteinMeals = new Meal<>();

        // Create Meal of each type
        VegetarianMeal dalTadka = new VegetarianMeal("Dal Tadka");
        VegetarianMeal paneerButterMasala = new VegetarianMeal("Paneer Butter Masala");

        VeganMeal alooGobhi = new VeganMeal("Aloo Gobhi");
        VeganMeal masoorDal = new VeganMeal("Masoor Dal");

        KetoMeal tandooriChicken = new KetoMeal("Tandoori Chicken");
        KetoMeal palakPaneer = new KetoMeal("Palak Paneer");

        HighProteinMeal grilledFish = new HighProteinMeal("Grilled Fish");
        HighProteinMeal rajmaChawal = new HighProteinMeal("Rajma Chawal");

        // Add Meals to Respective Lists
        vegetarianMeals.addMeal(dalTadka);
        vegetarianMeals.addMeal(paneerButterMasala);

        veganMeals.addMeal(alooGobhi);
        veganMeals.addMeal(masoorDal);

        ketoMeals.addMeal(tandooriChicken);
        ketoMeals.addMeal(palakPaneer);

        highProteinMeals.addMeal(grilledFish);
        highProteinMeals.addMeal(rajmaChawal);

        // Display All Meals
        System.out.println("Vegetarian Meals:");
        vegetarianMeals.displayMeals();

        System.out.println("\nVegan Meals:");
        veganMeals.displayMeals();

        System.out.println("\nKeto Meals:");
        ketoMeals.displayMeals();

        System.out.println("\nHigh-Protein Meals:");
        highProteinMeals.displayMeals();

        // Generate a Personalized Meal Plan
        MealUtility.generateMealPlan(dalTadka);
        MealUtility.generateMealPlan(alooGobhi);
        MealUtility.generateMealPlan(tandooriChicken);
        MealUtility.generateMealPlan(grilledFish);
    }
}

