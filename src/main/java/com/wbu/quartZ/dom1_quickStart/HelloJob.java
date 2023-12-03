package com.wbu.quartZ.dom1_quickStart;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.SchedulerException;

import java.time.LocalDateTime;

public class HelloJob implements Job {


    public void execute(JobExecutionContext context)
    {
        JobKey key = context.getJobDetail().getKey(); //获取JobDetail的Identity值
        Object tv1 = context.getTrigger().getJobDataMap().get("t1");
        Object tv2 = context.getTrigger().getJobDataMap().get("t2");
        Object jv1 = context.getJobDetail().getJobDataMap().get("j1");
        Object jv2 = context.getJobDetail().getJobDataMap().get("j2");
        Object sv = null;
        try {
            sv = context.getScheduler().getContext().get("skey");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        System.out.println("jobKey"+key);
        System.out.println(tv1+":"+tv2);
        System.out.println(jv1+":"+jv2);
        System.out.println(sv);
        System.out.println("hello:"+ LocalDateTime.now());
    }
}
