package Feb21;

import java.util.regex.Pattern;

public class IPAddressValidator {
    private static final String IP_REGEX =
        "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +
        "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

    private static final Pattern IP_PATTERN = Pattern.compile(IP_REGEX);

    public boolean isValidIPAddress(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        return IP_PATTERN.matcher(ip).matches();
    }
}
