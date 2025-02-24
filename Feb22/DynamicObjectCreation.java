package Feb22;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> studentClass = Class.forName("Student");

            // Get the default constructor
            Constructor<?> defaultConstructor = studentClass.getDeclaredConstructor();

            // Create an instance using Reflection (without 'new' keyword)
            Object studentObj = defaultConstructor.newInstance();

            // Invoke the display method
            Method displayMethod = studentClass.getMethod("display");
            displayMethod.invoke(studentObj);

            // Get the parameterized constructor
            Constructor<?> paramConstructor = studentClass.getDeclaredConstructor(String.class);

            // Create another instance with a parameter
            Object studentObj2 = paramConstructor.newInstance("John Doe");

            // Invoke the display method on the new instance
            displayMethod.invoke(studentObj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
