package Feb14;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change this to your desired file path

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
