package com.wbu.quartZ.dom1_quickStart;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuickStart {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //创建一个scheduler(调度器)
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 在定时器中放数据-->job可以获取数据
        scheduler.getContext().put("skey", "svalue");

        //创建一个Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                // 触发器放数据到JobDataMap中
                .usingJobData("t1", "tv1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        trigger.getJobDataMap().put("t2", "tv2");

        //声明一个job详情
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                // 作业详情将数据到JobDataMap中
                .usingJobData("j1", "jv1")
                .withIdentity("myjob", "mygroup").build();
        job.getJobDataMap().put("j2", "jv2");

        //注册trigger并启动scheduler
        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        TimeUnit.MINUTES.sleep(1);
    }
}
