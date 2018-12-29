package com.onestage.chapter5;

public class ProduceConsumerVersion3 {

    private int i = 0;
    private volatile boolean isProduceed = false;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            if (isProduceed) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            isProduceed = true;
            LOCK.notifyAll();
        }
    }

    public void consumer() {
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
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();




    }


}
