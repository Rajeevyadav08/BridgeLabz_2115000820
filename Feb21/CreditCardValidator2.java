package Feb21;

public class CreditCardValidator2 {
    public boolean isValidCreditCard(String cardNumber) {
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) return false;

        char firstDigit = cardNumber.charAt(0);
        return (firstDigit == '4' || firstDigit == '5');
    }
}
