package Feb21;

import java.util.*;
import java.util.regex.*;
  
public class ProgrammingLanguageExtractor1 {
    private static final List<String> LANGUAGES = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "Rust", "PHP", "TypeScript");

    public List<String> extractLanguages(String text) {
        List<String> foundLanguages = new ArrayList<>();
        for (String lang : LANGUAGES) {
            Pattern pattern = Pattern.compile("\\b" + lang + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(matcher.group());
            }
        }
        return foundLanguages;
    }
}
