package com.onestage.chapter15;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        Observable observable = new ObservableThread<>(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finished done");
            return null;
        });
        observable.start();
    }

}
