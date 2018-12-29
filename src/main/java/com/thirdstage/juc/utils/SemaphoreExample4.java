package com.thirdstage.juc.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample4 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        new Thread(()->{
            semaphore.drainPermits();
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("T1 get all");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            try {
                semaphore.acquire(2);
                System.out.println("t2 get");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
