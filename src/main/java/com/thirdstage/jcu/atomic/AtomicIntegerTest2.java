package com.thirdstage.jcu.atomic;

import java.util.concurrent.TimeUnit;

public class AtomicIntegerTest2 {

    private static final CompareAndSetLock lock = new CompareAndSetLock();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    dosomeThing2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    public static void dosomeThing() throws InterruptedException {
        synchronized (AtomicIntegerTest2.class) {
            System.out.println(Thread.currentThread().getName() + "get the lock ");
            TimeUnit.MINUTES.sleep(1);
        }
    }

    public static void dosomeThing2() throws InterruptedException {
        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName() + "get the lock ");
            TimeUnit.MINUTES.sleep(1);
        } catch (GetLockException e) {
            e.printStackTrace();
        }finally {
            lock.unLock();
        }

    }

}
