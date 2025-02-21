package Feb19;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destinationFile = "copy_largefile.txt";
        
        long startTime, endTime;
        
        // Copy using unbuffered streams
        startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Time taken (unbuffered): " + (endTime - startTime) / 1e6 + " ms");
        
        // Copy using buffered streams
        startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Time taken (buffered): " + (endTime - startTime) / 1e6 + " ms");
    }
}