package com.thirdstage.juc.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletionServiceExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureDefect2();
    }

    //无法回调
    private static void futureDefect1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        System.out.println("======");
        future.get();
    }

    /**
     * 执行一系列任务时。一个任务结束必须等到其他任务执行完才能获得结果
     * 可使用容器每个先接收
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void futureDefect2() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> callableList = Arrays.asList(() -> {
            sleep(10);
            System.out.println("10 finished");
            return 10;
        }, () -> {
            sleep(20);
            System.out.println("20 finished");
            return 20;
        });
        List<Future<Integer>> futures = service.invokeAll(callableList);
        Integer v1 = futures.get(0).get();
        System.out.println(v1);

        Integer integer = futures.get(1).get();
        System.out.println(integer);
    }


    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
