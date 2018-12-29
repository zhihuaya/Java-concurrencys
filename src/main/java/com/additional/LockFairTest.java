package com.additional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFairTest implements Runnable{

    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        LockFairTest lo = new LockFairTest();
        new Thread(lo).start();
        new Thread(lo).start();

    }


    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        }
    }
}
