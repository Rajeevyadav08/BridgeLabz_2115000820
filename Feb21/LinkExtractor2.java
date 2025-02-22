package Feb21;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class LinkExtractor2 {
    public List<String> extractLinks(String text) {
        if (text == null) return new ArrayList<>();

        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("(https?://[\\w.-]+(?:\\.[a-z]{2,6})+(?:/[\\w&%?=.-]*)?)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
