package com.thirdstage.jcu.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    private static AtomicStampedReference atomicRef =
            new AtomicStampedReference<Integer>(100,0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                boolean success = atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                System.out.println(Thread.currentThread().getName()+success);
                success = atomicRef.compareAndSet(101,100,atomicRef.getStamp(),atomicRef.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                int stamp = atomicRef.getStamp();
                System.out.println("before sleep:stamp"+stamp);
                TimeUnit.SECONDS.sleep(1);
                boolean success = atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                System.out.println(Thread.currentThread().getName()+success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
