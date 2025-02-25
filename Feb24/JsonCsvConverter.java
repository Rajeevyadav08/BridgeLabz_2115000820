package Feb24;

import java.io.*;
import java.util.*;
import org.json.*;

public class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String outputJsonFile = "students_output.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, outputJsonFile);
    }

    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            JSONArray jsonArray = new JSONArray(reader.readLine());
            JSONObject firstObject = jsonArray.getJSONObject(0);

            List<String> headers = new ArrayList<>(firstObject.keySet());
            writer.write(String.join(",", headers));
            writer.newLine();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                List<String> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(obj.get(header).toString());
                }
                writer.write(String.join(",", values));
                writer.newLine();
            }

            System.out.println("JSON converted to CSV: " + csvFile);
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvFile, String outputJsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputJsonFile))) {

            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");
            JSONArray jsonArray = new JSONArray();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values[i]);
                }
                jsonArray.put(jsonObject);
            }

            writer.write(jsonArray.toString(4)); // Pretty print with 4 spaces
            System.out.println("CSV converted back to JSON: " + outputJsonFile);
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
