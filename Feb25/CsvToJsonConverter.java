package Feb25;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("data.csv");

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        
        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
        List<Map<String, String>> data = iterator.readAll();
        
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(json);
    }
}

