package Feb21;

import java.util.*;
import java.util.regex.*;

public class DateExtractor1 {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\b(\\d{2}/\\d{2}/\\d{4})\\b");

    public List<String> extractDates(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> dates = new ArrayList<>();
        Matcher matcher = DATE_PATTERN.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}
