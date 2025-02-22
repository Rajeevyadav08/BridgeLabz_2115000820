package Feb21;

import java.util.regex.*;

public class SSNValidator2 {
    public static boolean isValidSSN(String ssn) {
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        return Pattern.matches(regex, ssn);
    }

    public static void main(String[] args) {
        System.out.println(isValidSSN("123-45-6789")); // ✅ true
        System.out.println(isValidSSN("123456789"));   // ❌ false
        System.out.println(isValidSSN("12-345-6789")); // ❌ false
    }
}
