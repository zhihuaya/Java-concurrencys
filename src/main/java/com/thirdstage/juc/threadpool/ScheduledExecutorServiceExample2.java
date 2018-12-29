package com.thirdstage.juc.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduledExecutorServiceExample2 {

    public static void main(String[] args) {


    }

    private static void test1(){
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        final AtomicLong interval = new AtomicLong(0L);
        executor.scheduleWithFixedDelay(() -> {
            long currentTimeMills = System.currentTimeMillis();
            if (interval.get() == 0){
                System.out.println("The first time task at"+currentTimeMills);

            }else {
                System.out.println("The actually spend "+(currentTimeMills-interval.get()));
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            interval.set(currentTimeMills);
        }, 1, 2, TimeUnit.SECONDS);
    }
}
