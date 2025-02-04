package Feb04;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to course " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println("Student " + student.getName() + " enrolled in course " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "No professor assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teachCourse(Course course) {
        course.assignProfessor(this);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        course.enrollStudent(this);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of courses: ");
        int courseCount = Integer.parseInt(scanner.nextLine());
        List<Course> courses = new ArrayList<>();
        
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter the name of course " + (i + 1) + ": ");
            String courseName = scanner.nextLine();
            courses.add(new Course(courseName));
        }
        
        System.out.print("Enter the number of professors: ");
        int professorCount = Integer.parseInt(scanner.nextLine());
        List<Professor> professors = new ArrayList<>();
        
        for (int i = 0; i < professorCount; i++) {
            System.out.print("Enter the name of professor " + (i + 1) + ": ");
            String professorName = scanner.nextLine();
            professors.add(new Professor(professorName));
        }
        
        System.out.print("Enter the number of students: ");
        int studentCount = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();
            students.add(new Student(studentName));
        }
        
        System.out.println("\nAssigning professors to courses...");
        for (Course course : courses) {
            System.out.print("Enter the professor for course " + course.getCourseName() + ": ");
            String professorName = scanner.nextLine();
            for (Professor professor : professors) {
                if (professor.getName().equals(professorName)) {
                    professor.teachCourse(course);
                    break;
                }
            }
        }
        
        System.out.println("\nEnrolling students in courses...");
        for (Student student : students) {
            System.out.print("Enter the course name for student " + student.getName() + " to enroll: ");
            String courseName = scanner.nextLine();
            for (Course course : courses) {
                if (course.getCourseName().equals(courseName)) {
                    student.enrollCourse(course);
                    break;
                }
            }
        }
        
        System.out.println("\nCourse Details:");
        for (Course course : courses) {
            course.showCourseDetails();
            System.out.println();
        }
        
        scanner.close();
    }
}
