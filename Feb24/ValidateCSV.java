package Feb24;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change the path if needed
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read and ignore the header

            System.out.println("Checking for invalid records...\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = data[2].trim();
                String phone = data[3].trim();

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid Record: " + line);
                    if (!emailMatcher.matches()) {
                        System.out.println("  → Error: Invalid Email Format (" + email + ")");
                    }
                    if (!phoneMatcher.matches()) {
                        System.out.println("  → Error: Invalid Phone Number (" + phone + ")");
                    }
                    System.out.println();
                }
            }

            System.out.println("Validation completed.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
