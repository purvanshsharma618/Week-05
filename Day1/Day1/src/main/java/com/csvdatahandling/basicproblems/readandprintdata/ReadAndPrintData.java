package com.csvdatahandling.basicproblems.readandprintdata;

import java.io.*;

public class ReadAndPrintData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 05\\Day1\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

