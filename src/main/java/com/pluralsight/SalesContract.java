package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean finance;
    private double vehiclePrice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold,   boolean finance, double vehiclePrice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.finance = false;
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

    public double formulaMonthlyPayment(double principal,double annualRate,int months){

        //convert annual interest rate to monthly decimal rate
double monthlyInterestRate = (annualRate /12) ;


        //calculate EMI
        double payment  =
                principal * monthlyInterestRate * Math.pow(1 +  monthlyInterestRate,months) /
                (Math.pow(1 + monthlyInterestRate, months)-1);


       return payment;
    }

    @Override
    public double getMonthlyPayment(){
        //check if customer did not finance

        if(finance == false){
            return 0;
        }

 // determine loan terms
        double annualRate;
        int months;

        if(vehiclePrice >= 10000){
            annualRate = .0425;
            months = 48;
        } else {
            annualRate = .0525;
            months = 24;
        }
        //get pricipal price also total price
        double principal = getTotalPrice();

        return formulaMonthlyPayment(principal,annualRate,months);
    }

}
