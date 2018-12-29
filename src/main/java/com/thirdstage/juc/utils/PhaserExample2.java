package com.thirdstage.juc.utils;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample2 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        for (int i = 1; i < 5; i++) {
            new Athlete(i, phaser).start();
        }
        new InjuredAthlete(5,phaser).start();
    }

    static class InjuredAthlete extends Thread {
        private final int NO;
        private final Phaser phaser;

        InjuredAthlete(int no, Phaser phaser) {
            this.NO = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(NO, phaser, "is runing...", "is end runing...");
                sport(NO, phaser, "is bicycle...", "is end bicycle...");
                System.out.println("i am in injured..=== i exit==");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    static class Athlete extends Thread {
        private final int NO;
        private final Phaser phaser;

        Athlete(int no, Phaser phaser) {
            this.NO = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(NO, phaser, "is runing...", "is end runing...");
                sport(NO, phaser, "is bicycle...", "is end bicycle...");
                sport(NO, phaser, "is jump...", "is end jump...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    private static void sport(int NO, Phaser phaser, String s, String s2) throws InterruptedException {
        System.out.println(NO + s);
        TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
        System.out.println(NO + s2);
        phaser.arriveAndAwaitAdvance();
    }
}
