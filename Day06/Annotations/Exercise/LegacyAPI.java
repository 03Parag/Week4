package com.Week4.Day06.Annotations.Exercise;

// LegacyAPI class
class LegacyAPI {
    // Deprecate the method to avoid usage
    @Deprecated
    void oldFeatures() {
        System.out.println("This is an old features. Use new feature instead.");
    }

    // Method for nem feature
    void newFeatures() {
        System.out.println("This is a new features");
    }
}

class Features {
    public static void main(String[] args) {
        // Create an instance of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Call the old feature method
        api.oldFeatures();

        // Call the new Feature method
        api.newFeatures();
    }
}
