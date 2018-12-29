package com.thirdstage.juc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceExample5 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        threadPoolExecutor.execute(()->{System.out.println("running");});
        threadPoolExecutor.getQueue().add(()->{System.out.println("add queue");});
    }

}
