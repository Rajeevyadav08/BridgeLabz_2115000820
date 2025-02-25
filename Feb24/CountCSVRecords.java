package Feb24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRecords {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change the path if needed
        int recordCount = countRecords(filePath);
        System.out.println("Number of records (excluding header): " + recordCount);
    }

    public static int countRecords(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip the header
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return count;
    }
}
