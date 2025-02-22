package Feb21;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ProgrammingLanguageExtractor {
    private static final List<String> LANGUAGES = Arrays.asList(
        "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Rust", "Swift", "Kotlin", "Ruby", "PHP", "TypeScript"
    );

    public List<String> extractLanguages(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        return LANGUAGES.stream()
                .filter(lang -> text.contains(lang))
                .collect(Collectors.toList());
    }
}
