package com.wbu.quartZ.dom2_trigger;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * 相关的信息看 CronExpression类注释 或者 /image/的图片
 */
public class CronExpressionTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(TriggerJob.class)
                .storeDurably()
                .withIdentity("TriggerJob", "group1")
                .usingJobData("job1", "job1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger","group1")
                .usingJobData("trigger","trigger1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ? *"))
                .build();

        //绑定
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println(StringUtils.uncapitalize("STTTTT"));
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
    }
}
