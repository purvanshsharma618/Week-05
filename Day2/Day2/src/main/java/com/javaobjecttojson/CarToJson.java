package com.javaobjecttojson;


import org.json.JSONObject;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
public class CarToJson {
    public static void main(String[] args) {
        // Create Car object
        Car car = new Car("Honda", "Civic", 2024);

        // Convert to JSON using JSONObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", car.getBrand());
        jsonObject.put("model", car.getModel());
        jsonObject.put("year", car.getYear());

        // Print JSON output
        System.out.println(jsonObject.toString());
    }
}