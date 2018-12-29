package com.additional;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Semaphore semaphore = new Semaphore(2);

    public void driveCar() {
        try {
            semaphore.acquire(2);
            System.out.println(Thread.currentThread().getName() + "  Driveing......");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "  arrive........");
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
