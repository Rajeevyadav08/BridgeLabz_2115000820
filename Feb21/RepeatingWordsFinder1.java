package Feb21;
import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder1 {
    public Set<String> findRepeatingWords(String text) {
        Set<String> repeatingWords = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            if (wordCount.get(word) > 1) {
                repeatingWords.add(word);
            }
        }
        return repeatingWords;
    }
}

