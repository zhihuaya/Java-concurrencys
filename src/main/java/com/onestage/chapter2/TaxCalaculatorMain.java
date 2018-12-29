package com.onestage.chapter2;

public class TaxCalaculatorMain {

    public static void main(String[] args) {
        TaxCalaculator calaculator = new TaxCalaculator(1000d,200d){
            @Override
            public double calcTax(){
                return getSalary()*0.1+getBonus()*0.15;
            }
        };
        double tax = calaculator.calcTax();
        System.out.println(tax);
    }

}
