package com.thirdstage.juc.utils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample2 {

    private final static ReentrantLock LOCK = new ReentrantLock(true);


    private static int data = 0;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            for (int i=0; i<2;i++ ) {
                useData();
            }
        }).start();
    }

    private static void buildData() {
        try {
            LOCK.lock();
            Optional.of("P:" + data).ifPresent(System.out::println);
            data++;
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void useData() {
        try {
            LOCK.lock();
            TimeUnit.SECONDS.sleep(1);
            Optional.of("C:" + data).ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

}
