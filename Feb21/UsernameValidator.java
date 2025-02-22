package Feb21;

import java.util.regex.Pattern;

public class UsernameValidator {
    private static final Pattern USERNAME_PATTERN = 
        Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4,14}$");

    public boolean isValid(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }
}
