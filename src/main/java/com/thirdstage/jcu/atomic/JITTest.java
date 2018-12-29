package com.thirdstage.jcu.atomic;

public class JITTest {

    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                while (!init){
                    System.out.println(".");
                }
            }
        }.start();
        Thread.sleep(10000);
        new Thread(()->{
            init=true;
            System.out.println("Set init to true");
        }).start();
    }

}
