package com.csvdatahandling.basicproblems.readandprintdata;

import java.io.*;

public class ReadAndPrintData {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day1\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\readandprintdata\\students.csv";

        // Try-with-resources to ensure BufferedReader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Split the line into columns using a comma as the delimiter
                String[] columns = line.split(",");

                // Print the ID and Name from each row
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Age: " + columns[2] + ", Marks: " + columns[3]);
            }
        } catch (IOException e) {
            // Handle any potential IO exceptions
            e.printStackTrace();
        }
    }
}
