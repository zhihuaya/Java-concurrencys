package com.onestage.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CaptureService {

    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10")
                .stream().map(CaptureService::createCaptureThread)
                .forEach(t -> {
                    t.start();
                    worker.add(t);
                });
        worker.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All Of Capture Are Finished").ifPresent(System.out::println);
    }

    public static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("The worker ["+Thread.currentThread().getName()+"] begin capture data");

        }, name);
    }

}
