package com.onestage.chapter8;

public interface ThreadPool {

    void execute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();

}
