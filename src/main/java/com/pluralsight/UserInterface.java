package com.pluralsight;

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
// step 1 : get price range from user min,max
        double minPrice = 0;
        double maxPrice = 0;
        boolean found = false;
        while (true) {
            try {
                minPrice = ConsoleHelper.promptForFloat("Enter minimum price you would like to see ");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid please enter a number: ");

            }
        }
        while (true) {
            try {
                maxPrice = ConsoleHelper.promptForFloat("Enter maximum price you would like to see");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid please enter a number: ");
            }
            //step 2: loop thru inventory, for each vehicle get their price
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                    System.out.println(v);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No vehicles found with price range of: " + minPrice + " to " + maxPrice);
            }
        }
    }
        private void getByMakeModel () {
            String make = ConsoleHelper.promptForString("Enter make you would like to see");
            String model = ConsoleHelper.promptForString("Enter model you would like to see");
            boolean found = false;

            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                    System.out.println(v);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No vehicle found for " + make + " " + model);
            }
        }

        private void getByYearRequest () {
            int minYear = ConsoleHelper.promptForInt("Enter minimum year");
            int maxYear = ConsoleHelper.promptForInt("Enter max year");
            boolean found = false;

            //loop thru vehicles
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                    System.out.println(v);
                    found = true;
                }

            }
            if (!found) {
                System.out.println("No vehicle found for year " + minYear + "or " + maxYear);
            }
        }

        private void getByColorRequest () {
            String color = ConsoleHelper.promptForString("Enter color you would like to see");
            boolean found = false;
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getColor().toLowerCase().contains(color)) {
                    System.out.println(v);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No vehicle found with color " + color);
            }
        }


        private void getByMileageRequest () {
            int minMileage = ConsoleHelper.promptForInt("Enter minimum mileage");
            int maxMileage = ConsoleHelper.promptForInt("Enter maximum mileage");
            boolean found = false;

            //loop thru the vehicles
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                    System.out.println(v);
                    found = true;
                }
                if (!found) {
                    System.out.println("No vehicles found with mileage of " + minMileage + "or " + maxMileage);
                }
            }

        }

        private void getByVehicleTypeRequest () {
            String type = ConsoleHelper.promptForString("Enter the type of vehicle you would like to see");
            boolean found = false;
            //loop
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getVehicleType().equalsIgnoreCase(type)) {
                    System.out.println(v);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No vehicles found for the type of " + type);


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
            try {
                int vin = ConsoleHelper.promptForInt("Enter vin number ");
                int year = ConsoleHelper.promptForInt("Enter year of vehicle");
                String make = ConsoleHelper.promptForString("Enter make of vehicle");
                String model = ConsoleHelper.promptForString("Enter model of vehicle");
                String type = ConsoleHelper.promptForString("Enter type of vehicle");
                String color = ConsoleHelper.promptForString("Enter color of vehicle");
                int odometer = ConsoleHelper.promptForInt("Enter mileage of vehicle");
                double price = ConsoleHelper.promptForFloat("Enter vehicle price");

                //create a new vehicle
                Vehicle newV = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(newV);
                 System.out.println("Vehicle has been added!");


            } catch (Exception e) {
                System.out.println("Vehicle could not be added! please try again");
                System.out.println("Error:" + e.getMessage());
            }

        }


        private void removeVehicleRequest () {

            try {
                int vin = ConsoleHelper.promptForInt("Enter VIN of vehicle to remove");

                Vehicle removed = null;

                for (Vehicle v : dealership.getAllVehicles()) {
                    if (v.getVin() == vin) {
                        removed = v;
                        break;
                    }
                }
                if (removed != null) {
                    dealership.removeVehicle(removed);

                } else {
                    System.out.println("Vehicle not found");
                }

            } catch (Exception e) {
                System.out.println("No VIN found please enter a valid VIN number:");
            }

        }
    }


