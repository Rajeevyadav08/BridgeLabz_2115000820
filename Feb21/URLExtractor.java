package Feb21;

import java.util.*;
import java.util.regex.*;

public class URLExtractor {
    private static final Pattern URL_PATTERN = Pattern.compile("(https?://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w._%&=?-]*)");

    public List<String> extractURLs(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> urls = new ArrayList<>();
        Matcher matcher = URL_PATTERN.matcher(text);
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        return urls;
    }
}

