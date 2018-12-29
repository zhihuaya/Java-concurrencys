package com.onestage.chapter5;

import java.util.List;

public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException;

    void unlock();

    List<Thread> getBlockedThreads();

}
