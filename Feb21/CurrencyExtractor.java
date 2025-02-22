package Feb21;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }
}
