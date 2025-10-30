package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private double vehiclePrice;


    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, double vehiclePrice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.vehiclePrice = vehiclePrice;
    }
 //getters and setters for vehicle price
    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
    //getters

    public double getExpectedEndingValue() {
        return vehiclePrice * 0.5;
    }

    public double getLeaseFee() {
        return vehiclePrice * .07;
    }

    //formula
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
    public double getTotalPrice(){
return vehiclePrice + getLeaseFee()  - getExpectedEndingValue();
    }

    @Override
    public double getMonthlyPayment(){
double principal = getTotalPrice();
double annualRate = .04;
int months = 36;

return formulaMonthlyPayment(principal,annualRate,months);

    }
}
