package com.additional;

import java.util.concurrent.CountDownLatch;

public class CountDownLunchTest3 {

    public static void main(String[] args) {
        CountDownLatch start = new CountDownLatch(1);
        start.countDown();
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
