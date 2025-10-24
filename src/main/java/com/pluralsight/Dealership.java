package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name; //instance variables
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;



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

public static void getVehiclesByPrice(){

}

public static void getVehiclesByMakeModel(){
    return null;
}
public static void getVehiclesByYear(){
    return null;
}

public static void getVehiclesByColor(){
    return null;
}
public static void getVehiclesByMileage(){
    return null;
}
public static void getVehiclesByType(){

return null;
}
public static void removeVehicles(){
//empty
}



}
