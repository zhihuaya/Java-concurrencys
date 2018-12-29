package com.onestage.chapter2;

public class TicketWindowRunnable implements Runnable {

    private int index = 1;
    private final static int MAX = 50;


    @Override
    public void run() {

        while (index <= MAX) {
            System.out.println("当前柜台:" + Thread.currentThread() + ":" + (index++));
        }

    }
}
