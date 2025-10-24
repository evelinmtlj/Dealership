package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name; //instance variables
    private String address;
    private String phone;
    private final ArrayList<Vehicle> inventory;



    //constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
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


    //arraylist

public  void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
}

public ArrayList<Vehicle> getAllVehicles(){
return inventory;
}

public   ArrayList<Vehicle> getVehiclesByPrice(Double min,Double max){
    return null;
}

public ArrayList<Vehicle> getVehiclesByMakeModel(String make,String model){
    return null;
}
public  ArrayList<Vehicle> getVehiclesByYear(int min,int max){
    return null;
}

public  ArrayList<Vehicle> getVehiclesByColor(String color){
    return null;
}
public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
    return null;
}
public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
return null;
}
public  void removeVehicle(Vehicle vehicle){
//empty
}



}
