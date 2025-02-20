package com.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read both JSON files into JsonNode
            JsonNode json1 = objectMapper.readTree(new File("file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("file2.json"));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Print merged JSON
            System.out.println("Merged JSON: " + mergedJson.toPrettyString());

            // Optionally, write the merged JSON to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
