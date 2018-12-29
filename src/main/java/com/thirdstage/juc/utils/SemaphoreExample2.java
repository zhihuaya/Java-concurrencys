package com.thirdstage.juc.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample2 {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);

        for(int i=0;i<2;i++){
            new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName()+" in");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" out");
                    TimeUnit.SECONDS.sleep(5);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName()+" release ");
            }).start();
        }
    }

}
