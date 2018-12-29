package com.onestage.chapter12;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {

    final static int MAX = 5;

    static volatile int init_value = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("The init_value is update to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.printf("The init_value is changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }

}
