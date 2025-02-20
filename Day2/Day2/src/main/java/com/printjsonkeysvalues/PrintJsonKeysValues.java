package com.printjsonkeysvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeysValues {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\printjsonkeysvalues\\data.json"));

            // Print all keys and values
            printJson(jsonNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print JSON keys and values
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate over object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), parentKey + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Iterate over array elements
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
