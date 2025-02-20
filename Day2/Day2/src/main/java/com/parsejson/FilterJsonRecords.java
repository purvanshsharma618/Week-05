package com.parsejson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private String email;
    private int age;

    // Getters (Required for Jackson)
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}

public class FilterJsonRecords {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into List of Person objects
            List<Person> people = objectMapper.readValue(new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\parsejson\\info.json"), new TypeReference<List<Person>>() {});

            // Filter records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered results
            filteredPeople.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
