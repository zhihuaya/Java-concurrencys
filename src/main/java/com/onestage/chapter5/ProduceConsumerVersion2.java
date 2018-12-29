package com.onestage.chapter5;

public class ProduceConsumerVersion2 {

    private int i = 0;
    private volatile boolean isProduceed = false;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            System.out.println("produce");
            if (isProduceed) {
                try {
                    LOCK.wait();
                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            isProduceed = true;
            LOCK.notify();
        }
    }

    public void consumer() {
        System.out.println("consumer");
        synchronized (LOCK) {
            if (!isProduceed) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "---" + i);
            isProduceed = false;
            LOCK.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println(i);
                pc.produce();
            }

        }, "p").start();



    }


}
