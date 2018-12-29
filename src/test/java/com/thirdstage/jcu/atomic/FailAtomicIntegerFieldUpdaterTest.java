package com.thirdstage.jcu.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class FailAtomicIntegerFieldUpdaterTest {

    static class Testme{
        protected volatile int i;
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Testme> updater = AtomicIntegerFieldUpdater.newUpdater(Testme.class,"i");
        Testme me = new Testme();
        updater.compareAndSet(me,0,1);
        int value = updater.get(me);
        System.out.println(value);
    }

}
