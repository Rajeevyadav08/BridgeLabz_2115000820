package Feb21;

import java.util.Set;
import java.util.HashSet;

public class BadWordFilter2 {
    private static final Set<String> badWords = new HashSet<>(Set.of("damn", "stupid"));

    public String censorBadWords(String text) {
        if (text == null) return null;
        String[] words = text.split("\\s+");
        StringBuilder censoredText = new StringBuilder();

        for (String word : words) {
            String sanitizedWord = word.replaceAll("[^a-zA-Z]", ""); // Remove punctuation for strict matching
            if (badWords.contains(sanitizedWord.toLowerCase())) {
                censoredText.append("**** ");
            } else {
                censoredText.append(word).append(" ");
            }
        }
        return censoredText.toString().trim();
    }
}
