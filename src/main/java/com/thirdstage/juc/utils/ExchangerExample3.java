package com.thirdstage.juc.utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ExchangerExample3 {

    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(() -> {
            AtomicReference<Integer> value = new AtomicReference<>(1);
            try {
                while (true) {
                    value.set(exchanger.exchange(value.get()));
                    System.out.println(Thread.currentThread().getName()+":"+value.get());
                    TimeUnit.SECONDS.sleep(3);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            AtomicReference<Integer> value = new AtomicReference<>(2);
            try {
                while (true) {
                    value.set(exchanger.exchange(value.get()));
                    System.out.println(Thread.currentThread().getName()+":"+value.get());
                    TimeUnit.SECONDS.sleep(2);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
