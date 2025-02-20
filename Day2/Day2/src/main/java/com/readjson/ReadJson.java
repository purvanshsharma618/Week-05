package com.readjson;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {
    public static void main(String[] args) {
        try {
            // Read JSON file as a String
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\readjson\\data.json")));

            // Convert String to JSONObject
            JSONObject jsonObject = new JSONObject(content);

            // Extract specific fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            // Print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
