package com.thirdstage.juc.threadpool;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample1 {
   public int ExecutorsExample1(){
       return 1;
   }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        Optional.of(Runtime.getRuntime().availableProcessors()).ifPresent(System.out::println);
    }

}
