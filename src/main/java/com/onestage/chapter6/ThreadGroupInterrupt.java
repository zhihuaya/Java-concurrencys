package com.onestage.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadGroupInterrupt {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("testGroup");
        new Thread(group,() -> {
            while (true){
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {

                    break;
                }
            }
            System.out.println("t1 exit");
        },"t1").start();
        new Thread(group,() -> {
            while (true){
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {

                    break;
                }
            }
            System.out.println("t2 exit");
        },"t2").start();

        TimeUnit.SECONDS.sleep(1);
        group.interrupt();
    }

}
