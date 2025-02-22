package Feb21;

import java.util.regex.Pattern;

public class CreditCardValidator {
    private static final String VISA_REGEX = "^4\\d{15}$";
    private static final String MASTERCARD_REGEX = "^5[1-5]\\d{14}$";

    private static final Pattern VISA_PATTERN = Pattern.compile(VISA_REGEX);
    private static final Pattern MASTERCARD_PATTERN = Pattern.compile(MASTERCARD_REGEX);

    public String validateCreditCard(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return "Invalid";
        }
        if (VISA_PATTERN.matcher(cardNumber).matches()) {
            return "Visa";
        }
        if (MASTERCARD_PATTERN.matcher(cardNumber).matches()) {
            return "MasterCard";
        }
        return "Invalid";
    }
}
