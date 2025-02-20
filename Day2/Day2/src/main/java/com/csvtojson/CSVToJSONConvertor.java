package com.csvtojson;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVToJSONConvertor {
    public static void main(String[] args) {
        CsvMapper csvMapper = new CsvMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            // Define schema using the first row (header) of the CSV
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            // Read CSV file and convert it to a list of maps
            MappingIterator<Map<String, String>> iterator =
                    csvMapper.readerFor(Map.class).with(schema).readValues(new File("data.csv"));
            List<Map<String, String>> csvData = iterator.readAll();

            // Convert the list to JSON
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);
            System.out.println("Converted JSON:\n" + jsonOutput);

            // Optionally, write JSON to a file
            jsonMapper.writeValue(new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\csvtojson\\output.json"), csvData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
