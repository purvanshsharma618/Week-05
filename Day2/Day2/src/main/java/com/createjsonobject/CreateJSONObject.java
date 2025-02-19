package com.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObject {
    public static void main(String[] args) {
        // Creating a JSON object
        JSONObject student = new JSONObject();

        // Adding fields in the required order
        student.put("name", "Aryan Sharma");
        student.put("age", 20);

        // Adding subjects at the end
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");

        student.put("subjects", subjects);

        // Printing the JSON object
        System.out.println(student.toString(4));
    }
}
