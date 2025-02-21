package Feb20;

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        File file = new File("data.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'data.txt' does not exist. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error: An issue occurred while reading the file.");
        }
    }
}


