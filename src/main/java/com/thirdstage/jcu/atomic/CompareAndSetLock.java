package com.thirdstage.jcu.atomic;

import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger(0);
    private Thread lockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException("获取锁失败");
        } else {
            lockedThread = Thread.currentThread();
        }

    }

    public void unLock() {
        if (0 == value.get()) {
            return;
        }
        if (lockedThread == Thread.currentThread())
            value.compareAndSet(1, 0);
    }

}
