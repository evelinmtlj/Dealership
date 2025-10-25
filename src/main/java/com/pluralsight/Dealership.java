package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name; //instance variables
    private String address;
    private String phone;
    private  ArrayList<Vehicle> inventory;



    //constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    //getters/setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


public  void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    System.out.println("Vehicle: " + vehicle + "has been added");
}

public ArrayList<Vehicle> getAllVehicles(){
    System.out.println("------ Displaying all vehicles -------");
return inventory;
}

public  void  getVehiclesByPrice(Double min,Double max){ //<- parameters inside
        boolean found = false;
        for (Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No vehicles within price range found");
        }
}

public void  getVehiclesByMakeModel(String make,String model) {
        boolean found = false;
    for (Vehicle v : inventory) {
        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
            System.out.println(v);
            found = true;
        }
    }
    if(!found) {
        System.out.println("No vehicles found with this make or model!");
    }

}
public  void  getVehiclesByYear(int min,int max){
    boolean found = false;
    for(Vehicle v: inventory) {
        if (v.getYear() >= min && v.getYear() <= max) {
            System.out.println(v);
            found = true;
        }
    }
    if(!found) {
        System.out.println("No vehicles found within the year range");
    }
}

public void getVehiclesByColor(String color){
   boolean found = false;
   for(Vehicle v: inventory) {
       if(v.getColor().equalsIgnoreCase(color)) {
           System.out.println(v);
           found = true;
       }
   }
   if(!found){
       System.out.println("No cars found with that color!");
   }
}
public void getVehiclesByMileage(int min, int max){
    boolean found = false;
            for(Vehicle v: inventory) {
                if(v.getOdometer() >= min && v.getOdometer() <= max) {
                    System.out.println(v);
                    found = true;
                }
            }
            if(!found) {
                System.out.println("No cars found within mileage range");
            }
}
public void getVehiclesByType(String vehicleType) {
    boolean found = false;
    for (Vehicle v : inventory) {
        if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
            System.out.println(v);
            found = true;
        }
    }
    if (!found) {
        System.out.println("No vehicles found of type:" + vehicleType);
    }
}
    public void removeVehicle(Vehicle vehicle) {
        if(inventory.remove(vehicle)) {
            System.out.println("Vehicle: " + vehicle + " has been removed");
        } else {
            System.out.println("Vehicle not found");
        }
    }



}

