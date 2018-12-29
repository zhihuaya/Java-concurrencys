package com.thirdstage.juc.threadpool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Timer/TimerTask
 * SchedulerExecutorService
 * crontab
 * cron4j
 * quartz
 */
public class TimerScheduler {

    public static void main(String[] args) {
        Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("===="+System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        timer.schedule(timerTask,1000,1000);
    }

}
