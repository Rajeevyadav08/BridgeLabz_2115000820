package Feb21;

import java.util.*;
import java.util.regex.*;

public class CapitalizedWordExtractor1 {
    private static final Pattern CAPITALIZED_PATTERN = Pattern.compile("\\b[A-Z][a-z]*\\b");

    public List<String> extractCapitalizedWords(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> capitalizedWords = new ArrayList<>();
        Matcher matcher = CAPITALIZED_PATTERN.matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }
}
