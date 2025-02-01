package Jan31;

public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA;
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayStudentInfo() {
        System.out.println("Postgraduate Student Roll Number: " + rollNumber + ", Name: " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Alice", 3.8);
        pgStudent.displayStudentInfo();
        System.out.println(pgStudent);
        pgStudent.setCGPA(3.9);
        System.out.println("Updated " + pgStudent);
    }
}