package Feb24;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static SecretKey secretKey;

    public static void main(String[] args) throws Exception {
        secretKey = generateSecretKey();
        String csvFile = "employees_encrypted.csv";

        writeEncryptedCSV(csvFile);
        readDecryptedCSV(csvFile);
    }

    private static SecretKey generateSecretKey() {
        return new SecretKeySpec("1234567890123456".getBytes(), AES); // 16-byte key
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    public static void writeEncryptedCSV(String filePath) {
        String[] employees = {
                "1,Alice,IT,alice@example.com,60000",
                "2,Bob,HR,bob@example.com,55000",
                "3,Charlie,Finance,charlie@example.com,65000"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Email,Salary");
            writer.newLine();

            for (String employee : employees) {
                String[] data = employee.split(",");
                data[3] = encrypt(data[3]); // Encrypt Email
                data[4] = encrypt(data[4]); // Encrypt Salary

                writer.write(String.join(",", data));
                writer.newLine();
            }
            System.out.println("Encrypted CSV file created.");
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            System.out.println("\nDecrypted Data:");
            System.out.println(header);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                data[3] = decrypt(data[3]); // Decrypt Email
                data[4] = decrypt(data[4]); // Decrypt Salary

                System.out.println(String.join(",", data));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
