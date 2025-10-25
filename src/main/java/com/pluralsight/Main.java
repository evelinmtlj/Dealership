package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Dealership dealership = DealShipFileManager.getDealership();
        //created an instance and call its display method
     UserInterface uInterface = new UserInterface(dealership);

     uInterface.display();

    }
}