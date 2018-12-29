package com.onestage.chapter2;

public class TaxCalaculator {

    private final double salary;
    private final double bonus;

    public TaxCalaculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double calcTax(){
        return 0.0d;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
