package com.thirdstage.juc.utils;

import java.util.concurrent.Exchanger;

public class ExchangerExample2 {

    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(()->{
            Object aobj = new Object();
            System.out.println("A will send the object "+aobj);
            try {
                Object exchange = exchanger.exchange(aobj);
                System.out.println("A recive the Object "+exchange);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            Object aobj = new Object();
            System.out.println("B will send the object "+aobj);
            try {
                Object exchange = exchanger.exchange(aobj);
                System.out.println("B recive the Object "+exchange);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

