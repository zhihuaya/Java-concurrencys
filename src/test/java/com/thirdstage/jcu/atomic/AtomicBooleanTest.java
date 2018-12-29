package com.thirdstage.jcu.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

    @Test
    public void testCreate(){
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        boolean b = atomicBoolean.get();
        System.out.println(b);
    }
    @Test
    public void testCreate2(){
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        boolean b = atomicBoolean.get();
        System.out.println(b);
    }

    @Test
    public void getandset(){
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        boolean andSet = atomicBoolean.getAndSet(false);
        System.out.println(andSet);
        System.out.println(atomicBoolean.get());
    }
    @Test
    public void compareandset(){
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        atomicBoolean.compareAndSet(true,false);
        System.out.println(atomicBoolean.get());
    }
}
