package Jan31;

public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Tech Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: $" + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 6, 1200.0);
        course1.displayCourseDetails();
        
        Course.updateInstituteName("Global Tech Institute");
        
        Course course2 = new Course("Python Development", 4, 1000.0);
        course2.displayCourseDetails();
    }
}

