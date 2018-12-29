package com.thirdstage.juc.threadpool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTask {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(11), r -> new Thread(r),
                new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0, 20).boxed().forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + "[" + i + "]" + "finish done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        List<Runnable> runnables = null;
        try {
            runnables = executor.shutdownNow();
        } catch (Exception e) {
        }
        System.out.println(runnables);
        //executor.awaitTermination(1,TimeUnit.HOURS);
        System.out.println("===over===");
        System.out.println(runnables.size());
        /**
         * 非守护线程
         */
    }

}
