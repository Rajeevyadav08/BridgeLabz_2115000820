package Feb21;

import java.util.List;
import java.util.regex.*;
import java.util.ArrayList;

public class LinkExtractor {
    private static final Pattern LINK_PATTERN = 
        Pattern.compile("\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\S*)?\\b");

    public List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return links;
        }

        Matcher matcher = LINK_PATTERN.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
