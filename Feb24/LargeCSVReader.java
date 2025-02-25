package Feb24;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_dataset.csv"; // Change this to your actual file path
        processLargeCSV(filePath, 100);
    }

    public static void processLargeCSV(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordCount = 0;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                recordCount++;

                // Process the line (For demo, we're just counting records)
                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
