package com.additional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.unlock();
    }

}
