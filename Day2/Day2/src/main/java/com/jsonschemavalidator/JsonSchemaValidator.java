package com.jsonschemavalidator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JsonSchemaValidator {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load JSON Schema
            FileInputStream schemaStream = new FileInputStream("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\jsonschemavalidator\\data.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(jsonSchema);

            // Load JSON Data
            FileInputStream dataStream = new FileInputStream("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\jsonschemavalidator\\data.json");
            JSONObject jsonData = new JSONObject(new JSONTokener(dataStream));

            // Validate JSON
            schema.validate(jsonData);
            System.out.println("JSON is valid!");

        } catch (org.everit.json.schema.ValidationException e) {
            System.out.println("JSON Validation Error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
