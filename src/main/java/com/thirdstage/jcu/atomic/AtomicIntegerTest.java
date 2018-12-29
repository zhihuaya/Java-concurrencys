package com.thirdstage.jcu.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

   /* private static volatile int value = 0;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5000) {
                    set.add(value);
                    int tem = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tem);
                    value += 1;
                    x++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5000) {
                    set.add(value);
                    int tem = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tem);
                    value += 1;
                    x++;
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(set.size());*/

    private static AtomicInteger value = new AtomicInteger();

    private static volatile int i = 20;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5000) {
                    int i = value.getAndIncrement();
                    set.add(i);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    x++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5000) {
                    int i = value.getAndIncrement();
                    set.add(i);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    x++;
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(set.size());


    }

}
