package com.thirdstage.juc.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReetrantLockExample1 {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.range(0, 1).forEach(i -> new Thread(() -> needLock()).start());
        IntStream.range(0, 1).forEach(i -> new Thread(() -> testTryLock()).start());

   }

    public static void needLock() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "doing works");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void testTryLock(){
        boolean result = lock.tryLock();
        if (result){
            System.out.println("get lock");
        }else {
            System.out.println("not get lock");
        }
    }

}
