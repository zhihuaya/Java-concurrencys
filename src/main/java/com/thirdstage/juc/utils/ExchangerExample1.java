package com.thirdstage.juc.utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample1 {

    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"start..");
            try {
                String result = exchanger.exchange("I am come from T-A");
                System.out.println(Thread.currentThread().getName()+" :Get value "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"A").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"start..");
            try {
                TimeUnit.SECONDS.sleep(10);
                String result = exchanger.exchange("I am come from T-B");
                System.out.println(Thread.currentThread().getName()+" :Get value "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"B").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"start..");
            try {

                String result = exchanger.exchange("I am come from T-C");
                System.out.println(Thread.currentThread().getName()+" :Get value "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"C").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"start..");
            try {
                String result = exchanger.exchange("I am come from T-D");
                System.out.println(Thread.currentThread().getName()+" :Get value "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"D").start();
    }

}
