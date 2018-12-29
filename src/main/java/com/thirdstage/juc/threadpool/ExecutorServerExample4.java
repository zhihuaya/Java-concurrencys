package com.thirdstage.juc.threadpool;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServerExample4 {

    public static void main(String[] args) {

    }

    public static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(
                i ->
                        (Callable<Integer>) () -> {
                            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
                            return i;
                        }
        ).collect(Collectors.toList());
        Integer value = executorService.invokeAny(callableList);
        System.out.println("=========finished========");
    }

}
