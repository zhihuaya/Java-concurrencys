package com.thirdstage.juc.utils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    private final static ReentrantLock LOCK = new ReentrantLock();

    private final static Condition CONDITION = LOCK.newCondition();

    private static int data = 0;

    private static volatile boolean noUse = true;

    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }).start();

        new Thread(() -> {
            for (int i=0; i<2;i++ ) {
                useData();
            }
        }).start();
    }

    private static void buildData() {
        try {
            LOCK.lock();
            while (noUse) {
                CONDITION.await();
            }

            Optional.of("P:" + data).ifPresent(System.out::println);
            data++;
            TimeUnit.SECONDS.sleep(1);
            noUse = true;
            CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void useData() {
        try {
            LOCK.lock();
            while (!noUse) {
                CONDITION.await();
            }
            TimeUnit.SECONDS.sleep(1);
            Optional.of("C:" + data).ifPresent(System.out::println);
            noUse = false;
            CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }


}
