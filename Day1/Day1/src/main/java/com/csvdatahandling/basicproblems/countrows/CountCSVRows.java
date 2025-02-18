package com.csvdatahandling.basicproblems.countrows;

import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day1\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\countrows\\student.csv";
        int rowCount = 0;

        // Try-with-resources to ensure BufferedReader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and skip the header row
            if ((line = br.readLine()) != null) {
                System.out.println("Header: " + line);  // Print header for reference
            }

            // Read each row and count records
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            // Print the total number of records (excluding the header)
            System.out.println("Total Records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
