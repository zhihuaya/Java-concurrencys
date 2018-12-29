package com.additional;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

    public static void main(String[] args) {
        Lock LOCK = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            LOCK.lock();
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            boolean flag = false;
            try {

                LOCK.lockInterruptibly();
                flag = true;
                System.out.println("get");
            } catch (InterruptedException e) {
                System.out.println("jdi");
            }finally {
                if(flag){
                    LOCK.unlock();
                }
            }
        }, "t1");
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }


}
