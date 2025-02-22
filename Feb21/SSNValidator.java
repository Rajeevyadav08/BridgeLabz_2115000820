package Feb21;

import java.util.regex.*;

public class SSNValidator {
    private static final Pattern SSN_PATTERN = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");

    public boolean isValidSSN(String ssn) {
        return ssn != null && SSN_PATTERN.matcher(ssn).matches();
    }

    public String extractSSN(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        Matcher matcher = SSN_PATTERN.matcher(text);
        return matcher.find() ? matcher.group() : null;
    }
}
