package com.thirdstage.jcu.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest{

    public static void main(String[] args) {
        Testme testme = new Testme();
        AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(
                Testme.class,"i"
        );
        for (int i=0;i<2;i++){
            new Thread(()->{
                int MAX =20;
                for(int j =0;j<MAX;j++){
                    int v = updater.getAndIncrement(testme);
                    System.out.println(Thread.currentThread().getName()+"-->"+v);
                }
            }).start();
        }
    }

    static class Testme{
        volatile int i;
    }

}
