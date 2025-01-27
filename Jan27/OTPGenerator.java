package Jan27;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OTPGenerator {

    public static int generateOTP() {
        Random rand = new Random();
        return rand.nextInt(900000) + 100000; // Generate a 6-digit random number
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> uniqueOTPs = new HashSet<>();
        for (int otp : otps) {
            if (!uniqueOTPs.add(otp)) {
                return false; // Duplicate OTP found
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
            for (int otp : otps) {
                System.out.println(otp);
            }
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}