package com.thirdstage.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServerExample2 {

    public static void main(String[] args) throws InterruptedException {
        discardOldestPolicy();
    }

    //直接拒绝策略
    public static void testAbortPoicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), (r -> new Thread(r)), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        executorService.execute(() -> System.out.print("x"));

    }

    //直接丢弃策略
    public static void discardPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), (r -> new Thread(r)), new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(90);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        executorService.execute(() -> System.out.print("x"));
        System.out.println("discardPolicy");

    }

    //直接丢弃策略
    public static void callerRunsPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), (r -> new Thread(r)), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        executorService.execute(() -> {
            System.out.print("x");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("discardPolicy");

    }

    //丢弃队列中最老策略
    public static void discardOldestPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), (r -> new Thread(r)), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        executorService.execute(() -> {
            System.out.print("x");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("discardOldestPolicy");

    }
}
