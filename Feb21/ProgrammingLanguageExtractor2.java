package Feb21;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ProgrammingLanguageExtractor2 {
    private static final List<String> LANGUAGES = Arrays.asList(
        "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Swift", "Ruby", "PHP", "Kotlin", "TypeScript",
        "Rust", "Perl", "Scala", "Dart", "Haskell", "Lua", "Objective-C", "R"
    );

    public static List<String> extractLanguages(String text) {
        return LANGUAGES.stream()
                .filter(text::contains)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(extractLanguages(text)); // Output: [Java, Python, JavaScript, Go]
    }
}
