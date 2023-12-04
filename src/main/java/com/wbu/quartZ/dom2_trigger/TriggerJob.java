package com.wbu.quartZ.dom2_trigger;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TriggerJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /**
         * trigger会覆盖jobDetail中的相同key的值
         */
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        System.out.println(mergedJobDataMap.get("trigger"));
        System.out.println("TriggerJob");
    }
}
