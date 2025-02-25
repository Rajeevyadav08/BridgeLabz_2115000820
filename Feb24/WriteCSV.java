package Feb24;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change the path if needed

        String[] employees = {
            "ID,Name,Department,Salary",
            "1,Alice,HR,50000",
            "2,Bob,Engineering,75000",
            "3,Charlie,Marketing,60000",
            "4,David,Finance,65000",
            "5,Emma,IT,70000"
        };

        writeCSV(filePath, employees);
    }

    public static void writeCSV(String filePath, String[] data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String row : data) {
                writer.write(row + "\n");
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }
}
