package Feb22;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInspector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Display class name
            System.out.println("\nClass: " + clazz.getName());

            // Display constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println("  " + constructor);
            }

            // Display fields
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println("  " + field);
            }

            // Display methods
            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("  " + method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } finally {
            scanner.close();
        }
    }
}
