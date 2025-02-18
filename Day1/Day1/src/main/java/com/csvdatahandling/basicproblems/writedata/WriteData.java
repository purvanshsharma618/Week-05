package com.csvdatahandling.basicproblems.writedata;

import java.io.*;

public class WriteData {
    public static void main(String[] args) {
        // Define the file path for the CSV file
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day1\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\writedata\\output.csv";

        // Try-with-resources to ensure BufferedWriter is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing the header row
            writer.write("ID,Name,Department,Salary\n");

            // Writing employee records
            writer.write("104,Raj Sharma,Finance,62000\n");
            writer.write("105,Adarsh Patel,Sales,58000\n");

            // Print success message
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
    }
}
