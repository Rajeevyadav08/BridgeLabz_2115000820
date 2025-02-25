package Feb24;

import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Change to your actual file path
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicateIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read and ignore the header
            System.out.println("Checking for duplicate records...\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (recordMap.containsKey(id)) {
                    duplicateIds.add(id);
                } else {
                    recordMap.put(id, line);
                }
            }

            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String id : duplicateIds) {
                    System.out.println(recordMap.get(id));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
