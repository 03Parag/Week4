package com.Week4.Day06.Annotations.Advanced_Level;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Simulate AppUser Roles
class AppUser {
    // Attributes of AppUser
    private String role;

    // Constructor for AppUser
    public AppUser(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Create a SecureService class with restricted methods
class SecureService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("UserName task executed successfully!");
    }
}

// Implement Role-Based Access Control (RBAC) Handler
class AccessController {
    public static void invokeWithAccessControl(AppUser appUser, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                String requiredRole = annotation.value();

                if (appUser.getRole().equals(requiredRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! AppUser role '" + appUser.getRole() + "' cannot access '" + methodName + "'.");
                }
            } else {
                System.out.println("Method '" + methodName + "' has no access restrictions.");
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Test Role-Based Access Control
class RoleBasedAccessControlExample {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        // Create an instance of app user
        AppUser adminUser = new AppUser("ADMIN");
        AppUser normalUser = new AppUser("USER");

        System.out.println("Admin trying to perform admin task:");
        AccessController.invokeWithAccessControl(adminUser, service, "performAdminTask");

        System.out.println("\nUserName trying to perform admin task:");
        AccessController.invokeWithAccessControl(normalUser, service, "performAdminTask");

        System.out.println("\nUserName trying to perform user task:");
        AccessController.invokeWithAccessControl(normalUser, service, "performUserTask");
    }
}
