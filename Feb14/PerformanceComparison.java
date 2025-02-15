package Feb14;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append(text);
        }
        long durationBuilder = System.nanoTime() - startTimeBuilder;

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append(text);
        }
        long durationBuffer = System.nanoTime() - startTimeBuffer;

        System.out.println("StringBuilder time: " + durationBuilder / 1_000_000 + " ms");
        System.out.println("StringBuffer time: " + durationBuffer / 1_000_000 + " ms");

        // FileReader word count
        String filePath = "largefile.txt"; // Change to your actual large file
        long startTimeFileReader = System.nanoTime();
        int wordsFileReader = countWordsUsingFileReader(filePath);
        long durationFileReader = System.nanoTime() - startTimeFileReader;

        // InputStreamReader word count
        long startTimeInputStreamReader = System.nanoTime();
        int wordsInputStreamReader = countWordsUsingInputStreamReader(filePath);
        long durationInputStreamReader = System.nanoTime() - startTimeInputStreamReader;

        System.out.println("FileReader word count: " + wordsFileReader + " (Time: " + durationFileReader / 1_000_000 + " ms)");
        System.out.println("InputStreamReader word count: " + wordsInputStreamReader + " (Time: " + durationInputStreamReader / 1_000_000 + " ms)");
    }

    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }
}
