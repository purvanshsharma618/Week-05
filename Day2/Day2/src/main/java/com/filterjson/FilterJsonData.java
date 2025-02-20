package com.filterjson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class User {
    private String name;
    private String email;
    private int age;

    // Getters (Required for Jackson)
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}

public class FilterJsonData {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into List of User objects
            List<User> users = objectMapper.readValue(new File("C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day2\\Day2\\src\\main\\java\\com\\filterjson\\user.json"), new TypeReference<List<User>>() {});

            // Filter users where age > 25
            List<User> filteredUsers = users.stream()
                    .filter(user -> user.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered results
            filteredUsers.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
