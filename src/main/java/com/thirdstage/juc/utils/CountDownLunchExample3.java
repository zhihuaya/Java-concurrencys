package com.thirdstage.juc.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLunchExample3 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        Thread mainThread = Thread.currentThread();

        new Thread(()->{
            try {
                Thread.sleep(10);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //latch.countDown();
        }).start();
        try {
            latch.await(1000, TimeUnit.MILLISECONDS);
            System.out.println("====");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
