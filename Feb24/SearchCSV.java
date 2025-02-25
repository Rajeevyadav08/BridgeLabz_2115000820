package Feb24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change the path if needed
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();
        
        searchEmployee(filePath, searchName);
        scanner.close();
    }

    public static void searchEmployee(String filePath, String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;
            br.readLine(); // Skip the header
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(name)) {  // Case-insensitive search
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
