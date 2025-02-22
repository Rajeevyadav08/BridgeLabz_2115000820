package Feb21;

import java.util.List;
import java.util.regex.Pattern;

public class BadWordFilter {
    private static final List<String> BAD_WORDS = List.of("damn", "stupid");

    public String censorBadWords(String text) {
        if (text == null) {
            return null;
        }
        String regex = "\\b(" + String.join("|", BAD_WORDS) + ")\\b";
        return text.replaceAll(regex, "****");
    }
}
