package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        Dealership dealership = DealShipFileManager.getDealership();
//        //created an instance and call its display method
//     UserInterface uInterface = new UserInterface(dealership);
//
//     uInterface.display();

        SalesContract sales = new SalesContract("10-21-2023","Jesica mtl","matuljesica@gmail.com","Toyota camry",true,12500);

        sales.setFinance(true);
        System.out.println(sales);



        LeaseContract lease = new LeaseContract("12-21-2021","Evelin ne","evelinttk@gmail.com","Honda civic",18000);
        System.out.println("\n " + lease);

//        System.out.println("----------------- Sales contract------------");
//        System.out.println("Vehicle price: $" + sales.getVehiclePrice());
//        System.out.println("Total price: $" + sales.getTotalPrice());
//        System.out.println("Monthly payment: $" + sales.getMonthlyPayment());

    }
}