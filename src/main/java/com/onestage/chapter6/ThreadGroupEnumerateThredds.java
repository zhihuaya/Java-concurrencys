package com.onestage.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThredds {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }, "MyThread");
        thread.start();
        TimeUnit.MICROSECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[mainGroup.activeCount()];
        int enumerate = mainGroup.enumerate(list);
        System.out.println(enumerate);
        int enumerate1 = mainGroup.enumerate(list, false);
        System.out.println(enumerate1);
        int maxPriority = Thread.currentThread().getThreadGroup().getMaxPriority();
        System.out.println(maxPriority);
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent());
        Thread.currentThread().getThreadGroup().list();

    }

}
