package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class DealShipFileManager {
    //method that reads from file

    public static Dealership getDealership() {

        ArrayList<Vehicle > vehicles = new ArrayList<>();
        Dealership dealership = new Dealership("Dealership","123 street rd","704-111-2233"); //object
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            //skips the first line
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //split the file by parts
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                // create new vehicle object
                Vehicle vehicle= new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                //add it to file

                // dealership.addvehicle(vehicle);


            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Inventory file not found! ");

        }

        return dealership;
    }
//populate the inventory with a list of vehicles
    public static void saveDealership(){

    }


}
