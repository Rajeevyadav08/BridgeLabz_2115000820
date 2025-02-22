package Feb21;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder2 {
    public static Set<String> findRepeatingWords(String text) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Case insensitive comparison
            if (!seen.add(word)) {
                repeated.add(word);
            }
        }
        return repeated;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        System.out.println(findRepeatingWords(text)); // Output: [is, repeated]
    }
}
