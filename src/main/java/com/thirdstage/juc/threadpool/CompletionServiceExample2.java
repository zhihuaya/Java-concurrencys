package com.thirdstage.juc.threadpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletionServiceExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        final List<Callable<Integer>> callableList = Arrays.asList(
                () -> {
                    sleep(5);
                    System.out.println("5 finished");
                    return 5;
                },
                () -> {
                    sleep(15);
                    System.out.println("15 finished");
                    return 15;
                }
        );
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(service);
        List<Future<Integer>> futures = new ArrayList<>();
        callableList.stream().forEach(callable -> futures.add(completionService.submit(callable)));
      //  Future<Integer> f ;
      /*  while ((f = completionService.take()) != null) {
            System.out.println(f.get());
        }*/
        Future<Integer> poll = completionService.poll(10,TimeUnit.SECONDS);
        System.out.println(poll.get());
    }

    private static void sleep(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
