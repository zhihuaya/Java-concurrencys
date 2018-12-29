package com.additional;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest2 {

    private static CyclicBarrier start = new CyclicBarrier(10,()->{
        System.out.println("比赛开始");
    });

    private static CountDownLatch countDownLatch = new CountDownLatch(10);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            final int NO = i;
                new Thread(()->{
                    System.out.println("选手"+NO+"就绪");
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("选手"+NO+"到达");
                    countDownLatch.countDown();
                }).start();
        }
        countDownLatch.await();
        System.out.println("比赛结束");
    }

}
