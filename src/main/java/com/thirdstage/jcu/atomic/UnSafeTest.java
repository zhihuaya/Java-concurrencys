package com.thirdstage.jcu.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnSafeTest {

    public static void main(String[] args) throws Exception {
        /*Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);*/

    /*    Unsafe unSafe = getUnSafe();
        System.out.println(unSafe);*/

        //Counter result :9848272
        //Time passed in ms471

        //Counter result :10000000
        //Time passed in ms928

        //Counter result :10000000
        //Time passed in ms819

        //Counter result :10000000
        //Time passed in ms578

        //Counter result :10000000
        //Time passed in ms1295
        ExecutorService service = Executors.newFixedThreadPool(1000);
        Counter counter = new CasCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("Counter result :" + counter.getCounter());
        System.out.println("Time passed in ms" + (end - start));
    }

    private static Unsafe getUnSafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    interface Counter {
        void increment();

        long getCounter();
    }

    static class StupidCounter implements Counter {

        private long counter;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class SyncCounter implements Counter {

        private long counter;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class LockCounter implements Counter {

        private final Lock lock = new ReentrantLock();
        private long counter;

        @Override
        public void increment() {
            try{
                lock.lock();
                counter++;
            }finally {
                lock.unlock();
            }

        }
        @Override
        public long getCounter() {
            return counter;
        }
    }


    static class AcomicCounter implements Counter {

        private AtomicLong counter = new AtomicLong();

        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class CasCounter implements Counter {

        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        CasCounter() throws Exception {
            unsafe=getUnSafe();
            offset=unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
        }
        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this,offset,current,current+1))
                current = counter;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class CounterRunnable implements Runnable {
        private final Counter counter;
        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

}
