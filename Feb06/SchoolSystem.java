package Feb06;
// Superclass: Person
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void displayRole() {
        System.out.println("Role: General Person");
    }
}

// Subclass: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Interface for Sports Participation
interface SportsParticipant {
    void playSport();
}

// Interface for Music Club Membership
interface MusicClubMember {
    void playInstrument();
}

// Subclass: SportsStudent (inherits from Student and implements SportsParticipant)
class SportsStudent extends Student implements SportsParticipant {
    SportsStudent(String name, int age, int grade) {
        super(name, age, grade);
    }

    @Override
    public void playSport() {
        System.out.println(name + " participates in the school's basketball team.");
    }
}

// Subclass: MusicTeacher (inherits from Teacher and implements MusicClubMember)
class MusicTeacher extends Teacher implements MusicClubMember {
    MusicTeacher(String name, int age, String subject) {
        super(name, age, subject);
    }

    @Override
    public void playInstrument() {
        System.out.println(name + " plays the piano in the music club.");
    }
}

// Main Class
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        Student student = new Student("Alice", 16, 10);
        Staff staff = new Staff("Mrs. Brown", 35, "Administration");
        SportsStudent sportsStudent = new SportsStudent("Bob", 17, 11);
        MusicTeacher musicTeacher = new MusicTeacher("Ms. Green", 45, "Music");

        Person[] persons = {teacher, student, staff, sportsStudent, musicTeacher};

        for (Person person : persons) {
            System.out.println("-------- Person Details --------");
            person.displayDetails();
            person.displayRole();
            if (person instanceof SportsParticipant) {
                ((SportsParticipant) person).playSport();
            }
            if (person instanceof MusicClubMember) {
                ((MusicClubMember) person).playInstrument();
            }
            System.out.println();
        }
    }
}
