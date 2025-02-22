package Feb21;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RepeatingWordsFinder {
    public Set<String> findRepeatingWords(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptySet();
        }

        String[] words = text.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        Set<String> repeatingWords = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                repeatingWords.add(word);
            }
        }
        return repeatingWords;
    }
}
