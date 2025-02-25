package Feb24;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            br1.readLine(); // Skip header

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], new String[]{data[1], data[2]}); // Store Name & Age
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
            return;
        }

        List<String[]> mergedRecords = new ArrayList<>();
        mergedRecords.add(new String[]{"ID", "Name", "Age", "Marks", "Grade"}); // New header

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            String line;
            br2.readLine(); // Skip header

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (studentData.containsKey(id)) {
                    String[] details = studentData.get(id);
                    mergedRecords.add(new String[]{id, details[0], details[1], data[1], data[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] record : mergedRecords) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Merged CSV file saved as: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
