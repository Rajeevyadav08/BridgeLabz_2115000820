package Feb21;

import java.util.regex.Pattern;

public class HexColorValidator {
    private static final Pattern HEX_COLOR_PATTERN = 
        Pattern.compile("^#([A-Fa-f0-9]{6})$");

    public boolean isValid(String colorCode) {
        return colorCode != null && HEX_COLOR_PATTERN.matcher(colorCode).matches();
    }
}
