package Feb25;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name; this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));
        System.out.println(new ObjectMapper().writeValueAsString(people));
    }
}
