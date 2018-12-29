package com.thirdstage.juc.threadpool;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.TimeUnit;

public class SimpleJod implements Job{

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("========"+System.currentTimeMillis());
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
