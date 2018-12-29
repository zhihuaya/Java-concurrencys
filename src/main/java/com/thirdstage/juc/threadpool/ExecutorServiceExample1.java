package com.thirdstage.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceExample1 {

    public static void main(String[] args) throws InterruptedException {
        //isShutDown();
        //isTerminal();
        poolError();
    }

    private static void isShutDown(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        executorService.execute(()-> System.out.println("after shutdown"));
    }

    private static void isTerminal(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println(((ThreadPoolExecutor)executorService).isTerminating());
      //  executorService.execute(()-> System.out.println("after shutdown"));
    }

    private static void poolError() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        IntStream.range(0,10).boxed().forEach(i->executorService.execute(()->System.out.print(1/0)));
        executorService.shutdown();
        executorService.awaitTermination(10,TimeUnit.MINUTES);

        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println(((ThreadPoolExecutor)executorService).isTerminating());
      //  executorService.execute(()-> System.out.println("after shutdown"));
    }

}
