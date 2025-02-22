package Feb21;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class EmailExtractor2 {
    public List<String> extractEmails(String text) {
        if (text == null) return new ArrayList<>();

        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
