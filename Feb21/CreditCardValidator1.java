package Feb21;

import java.util.regex.Pattern;

public class CreditCardValidator1 {
    private static final String VISA_PATTERN = "^4\\d{15}$";
    private static final String MASTERCARD_PATTERN = "^5\\d{15}$";

    public boolean isValidVisa(String cardNumber) {
        if (cardNumber == null) {
            return false;
        }
        return Pattern.matches(VISA_PATTERN, cardNumber);
    }

    public boolean isValidMasterCard(String cardNumber) {
        if (cardNumber == null) {
            return false;
        }
        return Pattern.matches(MASTERCARD_PATTERN, cardNumber);
    }
}
