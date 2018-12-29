package com.thirdstage.juc.utils;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PhaserExample1 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        final Phaser phaser = new Phaser();
        IntStream.rangeClosed(1,5).boxed().map(i->phaser).forEach(Tast::new);
        phaser.register();
        phaser.arriveAndAwaitAdvance();
        System.out.println("all of worker finished..");


    }

    static class Tast extends Thread{
        private final Phaser phaser ;

        Tast(Phaser phaser){
            this.phaser = phaser;
            this.phaser.register();
            start();
        }

        @Override
        public void run() {
            System.out.println("The Worker [ "+getName()+"] is working..");
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phaser.arriveAndAwaitAdvance();
        }
    }
}
