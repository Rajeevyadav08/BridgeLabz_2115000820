package Feb19;

import java.io.*;

public class ConvertUpperToLower {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion completed!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}