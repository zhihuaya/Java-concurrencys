package com.thirdstage.jcu.atomic;


import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDetailsTest {



    @Test
    public void testCreate() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
       /* System.out.println(atomicInteger.get());
        atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.get());
        atomicInteger.set(4);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndSet(5);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndAdd(5);
        System.out.println(atomicInteger.get());
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int v = atomicInteger.addAndGet(1);
                System.out.println(v);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int v = atomicInteger.addAndGet(1);
                System.out.println(v);
            }
        }).start();*/

        boolean b = atomicInteger.compareAndSet(1, 3);
        System.out.println(b);
        System.out.println(atomicInteger.get());
    }

}
