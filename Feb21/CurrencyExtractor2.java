package Feb21;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CurrencyExtractor2 {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        System.out.println(extractCurrencyValues(text)); // Output: [$45.99, 10.50]
    }
}
