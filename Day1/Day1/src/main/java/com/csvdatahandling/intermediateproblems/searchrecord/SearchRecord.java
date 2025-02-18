package com.csvdatahandling.intermediateproblems.searchrecord;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;


public class SearchRecord {
    public static void main(String[] args) throws Exception {
        //taking employee name as input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Employee Name:");
        String inputName = input.nextLine();


        //file path
        FileReader fr = new FileReader("C:\\Users\\purva\\Desktop\\Week 5 \\Day1\\Day1\\src\\main\\java\\com\\intermediateproblems\\searchrecord\\employees.csv");
        CSVReader csvr = new CSVReader(fr);


        String[] readLine; //store row


        while((readLine = csvr.readNext()) != null){
            String department = readLine[2];
            String salary = readLine[3];
            //check if input name is equal to employee, print department and salary
            if(Objects.equals(readLine[1].toLowerCase(), inputName.toLowerCase())){
                System.out.println("Department: "+ department+", Salary: "+ salary);
            }
        }
    }
}