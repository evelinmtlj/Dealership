package com.pluralsight;

import com.sun.security.jgss.GSSUtil;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class UserInterface {

    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;

    }


    public void display() {

        //init();
        Dealership dl = DealShipFileManager.getDealership();
        // System.out.println(dl.getAddress());
        String mainMenu = """
                                 *************************************
                                *     Welcome to the Main Screen   *
                                **************************************
                              1 - Find vehicles within a price range
                              2 - Find vehicles by make / model
                              3 - Find vehicles by year range
                              4 - Find vehicles by color
                              5 - Find vehicles by mileage range
                              6 - Find vehicles by type (car, truck, SUV, van)
                              7 - List ALL vehicles
                              8 - Add a vehicle
                              9 - Remove a vehicle
                              99 - Quit
                
                """;
        while (true) {
            System.out.println(mainMenu);
            int choice = ConsoleHelper.promptForInt("Enter your choice");

            switch (choice) {
                case 1:
                    getPriceRequest();
                    break;
                case 2:
                    getByMakeModel();
                    break;
                case 3:
                    getByYearRequest();
                    break;
                case 4:
                    getByColorRequest();
                    break;
                case 5:
                    getByMileageRequest();
                    break;
                case 6:
                    getByVehicleTypeRequest();
                    break;
                case 7:
                    getAllVehiclesRequest();
                    break;
                case 8:
                    addVehicleRequest();
                    break;
                case 9:
                    removeVehicleRequest();
                    break;
                case 99:
                    System.out.println("GOODBYE PLEASE VISIT US AGAIN! ");
                    return;

                default:
                    System.out.println("Invalid number please try again: ");
                    break;
            }
        }
    }

    //methods
    private void getPriceRequest() {
// get price range
        double minPrice = ConsoleHelper.promptForDouble("Enter minimum price");
        double maxPrice = ConsoleHelper.promptForDouble("Enter maximum price");

        //boolean found = dealership.getVehiclesByPrice(minPrice,maxPrice);

        ArrayList<Vehicle> foundVehicles = dealership.getVehiclesByPrice2(minPrice, maxPrice);

        if(!foundVehicles.isEmpty()){
            for(Vehicle v : foundVehicles){
                System.out.println(v);
            }
        }
        else{
            System.out.println("No vehicles found for price " + minPrice + " " + maxPrice);
        }


    }
        private void getByMakeModel () {
            String make = ConsoleHelper.promptForString("Enter make you would like to see");
            String model = ConsoleHelper.promptForString("Enter model you would like to see");


            ArrayList<Vehicle> mmv = dealership.getVehiclesByMakeModel(make,model);

            if(!mmv.isEmpty()) {
                for(Vehicle v: mmv) {
                    System.out.println(v);
                }
            }
            else {
                System.out.println("No vehicles found for " + make + " " + model+ " found");
            }
        }

        private void getByYearRequest () {
            int minYear = ConsoleHelper.promptForInt("Enter minimum year");
            int maxYear = ConsoleHelper.promptForInt("Enter max year");

            boolean found = dealership.getVehiclesByYear(minYear,maxYear);

            if(!found){
                System.out.println("No vehicles found within " + minYear + " "+ maxYear);
            }
        }

        private void getByColorRequest () {
            String color = ConsoleHelper.promptForString("Enter color you would like to see");

           boolean found =  dealership.getVehiclesByColor(color);

            if(!found){
                System.out.println("No vehicles found for "+ color + " vehicle");
            }
        }


    private void getByMileageRequest() {
        int minMileage = ConsoleHelper.promptForInt("Enter minimum mileage");
        int maxMileage = ConsoleHelper.promptForInt("Enter maximum mileage");

        ArrayList<Vehicle> vehicleMileage = dealership.getVehiclesByMileage(minMileage,maxMileage);
        if (!vehicleMileage.isEmpty()) {
            for (Vehicle v : vehicleMileage) {
                System.out.println(v);
            }
        } else {
            System.out.println("No vehicles found with " + minMileage + " " + maxMileage + "mileages");
        }
    }



        private void getByVehicleTypeRequest () {

               String type = ConsoleHelper.promptForString("Enter the type of vehicle you would like to see");
              boolean found =  dealership.getVehiclesByType(type);

              if(!found){
                  System.out.println("No vehicles found");
              }

        }


        private void getAllVehiclesRequest () {

            boolean found = false;
            for (Vehicle v : dealership.getAllVehicles()) {
                System.out.println(v);
                found = true;
            }


            if (!found) {
                System.out.println("No vehicles currently");


            }
        }

        private void addVehicleRequest () {

                int vin = ConsoleHelper.promptForInt("Enter vin number ");
                int year = ConsoleHelper.promptForInt("Enter year of vehicle");
                String make = ConsoleHelper.promptForString("Enter make of vehicle");
                String model = ConsoleHelper.promptForString("Enter model of vehicle");
                String type = ConsoleHelper.promptForString("Enter type of vehicle");
                String color = ConsoleHelper.promptForString("Enter color of vehicle");
                int odometer = ConsoleHelper.promptForInt("Enter mileage of vehicle");
                double price = ConsoleHelper.promptForDouble("Enter vehicle price");

                //create a new vehicle
                Vehicle newV = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(newV);
                 System.out.println("Vehicle has been added!");




        }


    private void removeVehicleRequest() {

        int vin = ConsoleHelper.promptForInt("Enter VIN of vehicle to remove");
        boolean removed = dealership.removeVehicle(vin);
        if (removed) {
            System.out.println("Vehicle removed!");
        } else {
            System.out.println("Vehicle not found!");
        }

    }
}


