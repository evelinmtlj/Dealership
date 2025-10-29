package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean finance;
    private double vehiclePrice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold,   boolean finance, double vehiclePrice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.finance = finance;
        this.vehiclePrice = vehiclePrice;
    }

    public double getSalesTaxAmount() {
        return vehiclePrice * .05;
    }

    public double getRecordingFee() {
        return 100;
    }

    public double getProcessingFee() {
        if(vehiclePrice < 10000) {
           return 295;
        } else {
           return 495;
        }

    }


    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public double getTotalPrice(){
return vehiclePrice + getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment(){

    }

}
