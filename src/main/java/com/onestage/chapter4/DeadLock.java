package com.onestage.chapter4;

public class DeadLock {

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read(){
        synchronized (MUTEX_READ){
            System.out.println(Thread.currentThread().getName()+"get READ lock");
            synchronized (MUTEX_WRITE){
                System.out.println(Thread.currentThread().getName()+"get WRITE lock");
            }
            System.out.println(Thread.currentThread().getName()+"release WRITE lovk");
        }
        System.out.println(Thread.currentThread().getName()+"release READ lovk");
    }

    public void write(){
        synchronized (MUTEX_WRITE){
            System.out.println(Thread.currentThread().getName()+"get WRITE lock");
            synchronized (MUTEX_READ){
                System.out.println(Thread.currentThread().getName()+"get READ lock");
            }
            System.out.println(Thread.currentThread().getName()+"release READ lovk");
        }
        System.out.println(Thread.currentThread().getName()+"release WRITE lovk");
    }

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true){
                deadLock.read();
            }
        },"READ").start();
        new Thread(() -> {
            while (true){
                deadLock.write();
            }
        },"WRITE").start();
    }

}
