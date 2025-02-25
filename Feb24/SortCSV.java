package Feb24;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change the path if needed
        sortAndPrintTopSalaries(filePath, 5);
    }

    public static void sortAndPrintTopSalaries(String filePath, int topN) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read the header
            
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }

            // Sort by salary (index 3), descending order
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            // Print top N highest-paid employees
            System.out.printf("%-5s %-10s %-15s %-10s%n", "ID", "Name", "Department", "Salary");
            System.out.println("------------------------------------------");

            for (int i = 0; i < Math.min(topN, records.size()); i++) {
                String[] data = records.get(i);
                System.out.printf("%-5s %-10s %-15s %-10s%n", data[0], data[1], data[2], data[3]);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
