package Feb21;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class CapitalizedWordsExtractor {
    public List<String> extractCapitalizedWords(String text) {
        if (text == null) return new ArrayList<>();

        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}

