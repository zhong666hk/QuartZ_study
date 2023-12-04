package com.wbu.quartZ.dom3_cluster;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

@Component
public class SpringJob extends QuartzJobBean {
    @Autowired
    private SpringService springService;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String triggerName = context.getTrigger().getKey().getName();
        StringJoiner stringJoiner = new StringJoiner("\t");
        stringJoiner.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        stringJoiner.add(springService.hello());
        stringJoiner.add("triggerName"+triggerName);
        System.out.println(stringJoiner);
    }
}
