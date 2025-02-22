package Feb21;

import java.util.List;
import java.util.regex.Pattern;

public class BadWordCensor {
    public String censorBadWords(String text, List<String> badWords) {
        if (text == null || badWords == null || badWords.isEmpty()) {
            return text;
        }

        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            text = text.replaceAll(regex, "****");
        }
        return text;
    }
}
