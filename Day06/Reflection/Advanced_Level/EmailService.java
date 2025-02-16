package com.Week4.Day06.Reflection.Advanced_Level;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

// Define @Inject Annotation for Dependency Injection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// EmailService class
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Email sent: " + message);
    }
}

// SMSService class
class SMSService {
    public void sendSMS(String message) {
        System.out.println("SMS sent: " + message);
    }
}

// NotificationService class
class NotificationService {
    @Inject
    private EmailService emailService;

    @Inject
    private SMSService smsService;

    public void notifyUser(String message) {
        emailService.sendEmail(message);
        smsService.sendSMS(message);
    }
}

// 4DIContainer class
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);

        // Inject dependencies
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();

                // Create or reuse an instance of the dependency
                Object dependency = instances.computeIfAbsent(fieldType, key -> {
                    try {
                        return fieldType.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to create instance of: " + fieldType.getName(), e);
                    }
                });

                field.setAccessible(true); // Allow modifying private fields
                field.set(instance, dependency);
            }
        }
    }

    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.get(clazz));
    }
}

// DependencyInjection class
class DependencyInjection {
    public static void main(String[] args) throws Exception {
        // Create an instance of DIContainer
        DIContainer container = new DIContainer();

        // Register main class that needs dependency injection
        container.register(NotificationService.class);

        // Retrieve the fully injected instance
        NotificationService notificationService = container.getInstance(NotificationService.class);

        // Call a method to verify successful dependency injection
        notificationService.notifyUser("Hello, Dependency Injection!");
    }
}

