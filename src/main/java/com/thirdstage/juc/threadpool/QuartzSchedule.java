package com.thirdstage.juc.threadpool;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzSchedule {

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = newJob(SimpleJod.class)
                .withIdentity("Job1","Group1").build();

        Trigger trigger = newTrigger().withIdentity("trigger1","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

}

