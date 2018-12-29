package com.thirdstage.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorsExample {
    public static void main(String[] args) throws InterruptedException {

        //useCacheThreadPool();
        useFixedSizePool();

    }


    private static void useSinglePool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

    private static void useFixedSizePool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
        executorService.execute(()->System.out.print("====="));
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

        IntStream.range(0,100).boxed().forEach(i->executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"["+i+"]");
        }));

        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
        executorService.shutdown();
    }

    private static void useCacheThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
        executorService.execute(()->System.out.print("====="));
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

        IntStream.range(0,100).boxed().forEach(i->executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"["+i+"]");
        }));

        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
    }
}
