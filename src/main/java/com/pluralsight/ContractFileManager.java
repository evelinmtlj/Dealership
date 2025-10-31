package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {


        private String fileName;

        //store the name of the file
        public ContractFileManager(String fileName){
            this.fileName = fileName;
        }

        public void appendContract(String contractLine){
            try(FileWriter fw = new FileWriter("contracts.csv",true)) {
                fw.write(contractLine + "\n");
            } catch (IOException e) {
                System.out.println("Error saving contract" + e.getMessage());
            }
        }

//        System.out.println(contract.getVehicleSold().getVin());
//        System.out.println(contract.getVehicleSold().getPrice());
//        System.out.println(contract.getTotalPrice());
//        System.out.println(contract.getCustomerName());


}
