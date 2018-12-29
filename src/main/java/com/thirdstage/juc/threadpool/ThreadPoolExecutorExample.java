package com.thirdstage.juc.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), r->new Thread(r),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));
        executor.execute(()->sleepSecounds(15));

        System.out.println(executor.getActiveCount());
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getQueue().size());
        System.out.println(executor.getMaximumPoolSize());
       /* sleepSecounds(10);
        System.out.println(executor.getActiveCount());
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getQueue().size());
        System.out.println(executor.getMaximumPoolSize());*/
    }

    private static void sleepSecounds(long seconds) {
        try {
            System.out.println("*" + Thread.currentThread().getName() + "*");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
