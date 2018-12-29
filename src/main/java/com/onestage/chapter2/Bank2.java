package com.onestage.chapter2;

public class Bank2 {

    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(ticketWindowRunnable,"1号");
        thread1.start();
        Thread thread2 = new Thread(ticketWindowRunnable,"2号");
        thread2.start();
        Thread thread3 = new Thread(ticketWindowRunnable,"3号");
        thread3.start();
    }

}
