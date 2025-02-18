package com.csvdatahandling.basicproblems;

import java.io.*;
public class WriteData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day1\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\output.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Raj Sharma,Finance,62000\n");
            writer.write("105,Adarsh Patel,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

