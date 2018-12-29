package com.thirdstage.juc.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLunchExample2 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("do something ....");
            try {
                TimeUnit.SECONDS.sleep(10);
                latch.await();
                System.out.println("do other work...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            System.out.println("get some data for other ..");
            latch.countDown();
        }).start();
    }

}
