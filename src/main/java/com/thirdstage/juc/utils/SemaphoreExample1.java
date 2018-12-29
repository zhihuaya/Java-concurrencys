package com.thirdstage.juc.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample1 {

    public static void main(String[] args) {

        final SemaphoreLock lock = new SemaphoreLock();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+" release the lock");
            }

        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" is Running");
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }).start();

    }

    static class SemaphoreLock{
        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unlock(){
            semaphore.release();
        }
    }

}
