package com.thirdstage.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorBuild {

    public static void main(String[] args) {

        int activeCount = -1;
        int queueSize = -1;

        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        while (true) {
            if (activeCount != executor.getActiveCount() || queueSize != executor.getQueue().size()) {
                System.out.println(executor.getActiveCount());
                System.out.println(executor.getCorePoolSize());
                System.out.println(executor.getQueue().size());
                System.out.println(executor.getMaximumPoolSize());
                activeCount = executor.getActiveCount();
                queueSize = executor.getQueue().size();
                System.out.println("=======================");
            }
        }
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> new Thread(r), new ThreadPoolExecutor.AbortPolicy());
        System.out.println("The ThreadPoolExecutor create done.");
        executor.execute(() -> sleepSecounds(100));
        executor.execute(() -> sleepSecounds(100));
        executor.execute(() -> sleepSecounds(100));
        executor.execute(() -> sleepSecounds(100));
        return executor;
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
