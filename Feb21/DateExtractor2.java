package Feb21;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class DateExtractor2 {
    public List<String> extractDates(String text) {
        if (text == null) return new ArrayList<>();

        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(\\d{2}/\\d{2}/\\d{4})\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}
