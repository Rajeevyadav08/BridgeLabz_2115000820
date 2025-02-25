package Feb24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Change the path if needed
        filterStudents(filePath, 80);
    }

    public static void filterStudents(String filePath, int threshold) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    System.out.printf("%-5s %-10s %-5s %-5s%n", data[0], data[1], data[2], data[3]);
                    System.out.println("------------------------------");
                    isHeader = false;
                    continue;
                }

                int marks = Integer.parseInt(data[3]);
                if (marks > threshold) {
                    System.out.printf("%-5s %-10s %-5s %-5s%n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
