package com.thirdstage.jcu.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    @Test
    public void test1(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        int i = array.get(4);
        System.out.println(i);
    }

}
