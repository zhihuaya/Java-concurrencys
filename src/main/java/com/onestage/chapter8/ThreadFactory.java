package com.onestage.chapter8;

public interface ThreadFactory {

    Thread createThread(Runnable runnable);

}
