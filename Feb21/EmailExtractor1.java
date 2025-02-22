package Feb21;

import java.util.*;
import java.util.regex.*;

public class EmailExtractor1 {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");

    public List<String> extractEmails(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> emails = new ArrayList<>();
        Matcher matcher = EMAIL_PATTERN.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
