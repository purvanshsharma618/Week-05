package com.validateusingjackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\validateusingjackson\\file.json");

        try {
            // Read JSON and validate syntax
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            System.out.println("JSON is valid: " + jsonNode.toPrettyString());
        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}

