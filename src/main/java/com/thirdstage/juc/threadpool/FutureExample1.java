package com.thirdstage.juc.threadpool;

import java.util.concurrent.*;

public class FutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        Future<Integer> future = threadPoolExecutor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println("do something wark");
        System.out.println(future.get(3,TimeUnit.SECONDS));
    }

}
