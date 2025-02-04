package Feb04;

import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.enrollInCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showSchoolDetails() {
        System.out.println("School: " + schoolName);
        System.out.println("Students enrolled in the school:");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                System.out.println("- " + student.getName());
            }
        }
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        // Creating courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        // Enrolling students in courses
        course1.enrollStudent(student1);  // Alice enrolls in Mathematics
        course1.enrollStudent(student2);  // Bob enrolls in Mathematics
        course2.enrollStudent(student1);  // Alice enrolls in Science
        course3.enrollStudent(student2);  // Bob enrolls in History
        course3.enrollStudent(student3);  // Charlie enrolls in History

        // Creating a school and adding students
        School school = new School("Greenwood High");
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Showing details
        System.out.println("\nSchool Details:");
        school.showSchoolDetails();

        System.out.println("\nStudent Details:");
        student1.showCourses();
        student2.showCourses();
        student3.showCourses();

        System.out.println("\nCourse Details:");
        course1.showEnrolledStudents();
        course2.showEnrolledStudents();
        course3.showEnrolledStudents();
    }
}
