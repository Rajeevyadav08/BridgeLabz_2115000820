package Feb06;

class Course {
    String courseName;
    int duration; 

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // Discount in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Course Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: $" + calculateFinalFee());
    }
}

public class EducationalCourseSystem {
    public static void main(String[] args) {
        Course basicCourse = new Course("Introduction to Programming", 8);
        OnlineCourse onlineCourse = new OnlineCourse("Java Basics", 6, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Java", 10, "Coursera", true, 500.0, 20.0);

        Course[] courses = {basicCourse, onlineCourse, paidCourse};

        for (Course course : courses) {
            System.out.println("-------- Course Info --------");
            course.displayCourseInfo();
            System.out.println();
        }
    }
}

