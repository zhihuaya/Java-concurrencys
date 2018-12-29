package com.thirdstage.juc.utils;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample3 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        for(int i=1;i<6;i++){
            new PhaserExample2.Athlete(i,phaser).start();
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
            System.out.println(NO+"is runing...");
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(NO+"is end runing...");
                phaser.arriveAndAwaitAdvance();

                System.out.println(NO+"is bicycle...");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(NO+"is end bicycle...");
                phaser.arriveAndAwaitAdvance();
                System.out.println(NO+"is jump...");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(NO+"is end jump...");
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
