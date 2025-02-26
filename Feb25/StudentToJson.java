package Feb25;

import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int age;
    private List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getSubjects() { return subjects; }
}

public class StudentToJson {
    public static void main(String[] args) {
        try {
            Student student = new Student("Alice Johnson", 22, Arrays.asList("Mathematics", "Physics", "Computer Science"));
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(student);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
