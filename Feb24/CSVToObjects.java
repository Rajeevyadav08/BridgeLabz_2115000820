package Feb24;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Marks: %d", id, name, age, marks);
    }
}

public class CSVToObjects {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Change the path if needed
        List<Student> students = readCSV(filePath);

        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                int marks = Integer.parseInt(data[3].trim());

                studentList.add(new Student(id, name, age, marks));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return studentList;
    }
}
