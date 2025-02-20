package com.jsonreportgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/company_db"; // Change for PostgreSQL
        String user = "root";  // Change your DB username
        String password = "password";  // Change your DB password

        // JSON output file
        String outputFile = "employee_report.json";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            List<Map<String, Object>> employeeList = new ArrayList<>();

            // Process the result set
            while (rs.next()) {
                Map<String, Object> employee = new HashMap<>();
                employee.put("id", rs.getInt("id"));
                employee.put("name", rs.getString("name"));
                employee.put("email", rs.getString("email"));
                employee.put("age", rs.getInt("age"));
                employee.put("department", rs.getString("department"));

                employeeList.add(employee);
            }

            // Convert to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonReport = objectMapper.writeValueAsString(employeeList);

            // Save JSON to file
            try (FileWriter fileWriter = new FileWriter(new File(outputFile))) {
                fileWriter.write(jsonReport);
            }

            System.out.println("JSON report generated successfully: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
