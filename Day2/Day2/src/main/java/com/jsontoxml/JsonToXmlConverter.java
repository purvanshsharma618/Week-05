package com.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        try {
            // Read JSON file into JsonNode
            JsonNode jsonNode = jsonMapper.readTree(new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\jsontoxml\\data.json"));

            // Convert JSON to XML
            String xmlOutput = xmlMapper.writeValueAsString(jsonNode);
            System.out.println("Converted XML:\n" + xmlOutput);

            // Optionally, write the XML output to a file
            xmlMapper.writeValue(new File("output.xml"), jsonNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
