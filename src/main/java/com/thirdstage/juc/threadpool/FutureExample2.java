package com.thirdstage.juc.threadpool;

import java.util.concurrent.*;

public class FutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        isDone();
    }

    private static void isDone() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5;
        });
        Integer result = future.get();
        System.out.println(result+""+future.isDone());

    }

}
