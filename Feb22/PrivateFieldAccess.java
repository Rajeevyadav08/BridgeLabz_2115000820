package Feb22;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);
            person.displayAge();

            // Get the private field "age" using Reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true); // Bypass access restrictions

            // Modify the private field
            ageField.set(person, 30);

            // Retrieve and print the modified value
            System.out.println("Modified Age: " + ageField.get(person));

            // Display age using the method
            person.displayAge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
