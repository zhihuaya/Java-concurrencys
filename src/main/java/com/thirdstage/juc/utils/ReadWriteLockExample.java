package com.thirdstage.juc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final static ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock(true);

    private final static Lock readLock = LOCK.readLock();
    private final static Lock writeLock = LOCK.writeLock();

    private final static List<Long> data = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> read()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> read()).start();
    }

    public static void write() {
        try {
            LOCK.writeLock();
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.writeLock();
        }
    }

    public static void read() {
        try {
            readLock.lock();
            TimeUnit.SECONDS.sleep(5);
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName() + "=======");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

}
