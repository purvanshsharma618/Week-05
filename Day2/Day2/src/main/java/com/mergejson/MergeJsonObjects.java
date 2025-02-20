package com.mergejson;

import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        // Create first JSON object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Raj Sharma");
        json1.put("email", "rajsharma@example.com");

        // Create second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("age", 21);
        json2.put("city", "Lakhnadon");

        // Merge json2 into json1
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        // Print merged JSON object
        System.out.println("Merged JSON: " + json1.toString(4)); // Pretty print with indentation
    }
}
