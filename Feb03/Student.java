package Feb03;
import java.util.Scanner;
public class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("\nUniversity: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully for " + name);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students to enroll: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Grade: ");
            String grade = scanner.nextLine();
            students[i] = new Student(name, rollNumber, grade);
        }
        displayTotalStudents();
        System.out.println("\n--- Student Records ---");
        for (Student student : students) {
            student.displayStudentDetails();
        }
        System.out.print("\nDo you want to update a student's grade? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Roll Number: ");
            int rollToUpdate = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New Grade: ");
            String newGrade = scanner.nextLine();
            for (Student student : students) {
                if (student.rollNumber == rollToUpdate) {
                    student.updateGrade(newGrade);
                    break;
                }
            }
            System.out.println("\n--- Updated Student Records ---");
            for (Student student : students) {
                student.displayStudentDetails();
            }
        }
        scanner.close();
    }
}
