package com.poolthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CachedThreadPoolTest1 {

    private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        IntStream.range(0,100)
                .forEach((e)-> cacheThreadPool.
                        execute(() -> {
                                    System.out.println(Thread.currentThread().getName() + "====" + e);
                                    try {
                                        TimeUnit.SECONDS.sleep(2);
                                    } catch (InterruptedException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                        ));
    }

}
