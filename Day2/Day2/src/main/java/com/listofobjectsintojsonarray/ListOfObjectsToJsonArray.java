package com.listofobjectsintojsonarray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

// POJO class
class Person {
    private String name;
    private String email;
    private int age;

    // Constructor
    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters (required for Jackson)
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}

public class ListOfObjectsToJsonArray {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Raj Sharma", "rajsharma@example.com", 21));
        people.add(new Person("Ram Sharma", "ramsharma@example.com", 19));

        // Convert List to JSON array
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray = objectMapper.writeValueAsString(people);
            System.out.println("JSON Array: " + jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
