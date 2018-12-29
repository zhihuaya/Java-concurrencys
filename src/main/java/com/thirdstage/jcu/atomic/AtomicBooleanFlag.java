package com.thirdstage.jcu.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanFlag {

    private static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (flag){
                try {
                    TimeUnit.SECONDS.sleep(2);
                   // System.out.println("i am working");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i am finishing");
        }).start();

        TimeUnit.SECONDS.sleep(3);
        new Thread(()->{
            flag=false;
            System.out.println("flag to be flase");
        }).start();
    }

}
