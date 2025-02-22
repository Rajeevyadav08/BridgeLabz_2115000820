package Feb21;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class MonetaryValueExtractor {
    private static final Pattern MONEY_PATTERN = Pattern.compile("\\$?\\d+\\.\\d{2}");

    public List<String> extractMonetaryValues(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        Matcher matcher = MONEY_PATTERN.matcher(text);
        List<String> values = new ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
}
