package com.onestage.chapter7;

import java.util.concurrent.TimeUnit;

public class ThreadHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The Hook Thread 1 is Running");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Hook Thread 1 will exit");

        }));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The Hook Thread 2 is Running");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Hook Thread 2 will exit");

        }));
        System.out.println("The Program will is Stopping");
    }


}
