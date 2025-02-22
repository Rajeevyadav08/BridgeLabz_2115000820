package Feb21;

import java.util.regex.Pattern;

public class IPAddressValidator1 {
    private static final String IP_PATTERN =
        "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

    private static final Pattern pattern = Pattern.compile(IP_PATTERN);

    public boolean isValidIP(String ip) {
        if (ip == null) {
            return false;
        }
        return pattern.matcher(ip).matches();
    }
}
