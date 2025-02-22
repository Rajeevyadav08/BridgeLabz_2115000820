package Feb21;

import java.util.List;
import java.util.regex.*;
import java.util.ArrayList;

public class CapitalizedWordExtractor {
    private static final Pattern CAPITALIZED_WORD_PATTERN = 
        Pattern.compile("\\b[A-Z][a-z]*\\b");

    public List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return words;
        }

        Matcher matcher = CAPITALIZED_WORD_PATTERN.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
