package com.thirdstage.juc.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduledExecutorServiceExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
       /* ScheduledFuture<?> work = executor.schedule(() -> System.out.println("i will work"), 2, TimeUnit.SECONDS);
        System.out.println(work.cancel(true));*/

        ScheduledFuture<Integer> future = executor.schedule(() -> 2, 2, TimeUnit.SECONDS);
        System.out.println(future.get());

        /*ScheduledFuture<?> future1 = executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am running" + System.currentTimeMillis());
        }, 1, 2, TimeUnit.SECONDS);*/
        final AtomicLong interval = new AtomicLong(0L);
        executor.scheduleAtFixedRate(() -> {
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
