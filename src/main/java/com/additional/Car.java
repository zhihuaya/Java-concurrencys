package com.additional;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Car {

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        Driver driver = new Driver();
        for (int i = 1; i < 100; i++) {
            executor.execute(driver::driveCar);
        }
    }

}
