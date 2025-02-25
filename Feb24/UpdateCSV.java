package Feb24;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv"; // Original CSV file
        String outputFile = "updated_employees.csv"; // Updated CSV file
        updateSalaries(inputFile, outputFile);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                if (isHeader) {
                    records.add(data); // Add header as is
                    isHeader = false;
                    continue;
                }

                if (data[2].equalsIgnoreCase("IT")) { // If department is "IT"
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10; // Increase by 10%
                    data[3] = String.format("%.2f", salary);
                }

                records.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated CSV file saved as: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
