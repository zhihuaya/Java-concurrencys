package com.onestage.chapter3;

public class ThreadSleep {

    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2_000l);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format(("Total spend %d ms"),(endTime - startTime)));
        }).start();

        long startTime = System.currentTimeMillis();
        sleep(3_000l);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d" , (endTime - startTime)));
    }

    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){

        }
    }

}
