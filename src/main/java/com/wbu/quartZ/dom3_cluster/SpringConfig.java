package com.wbu.quartZ.dom3_cluster;

import org.quartz.*;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    @QuartzDataSource
    public DataSource qDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/quartz?characterEncoding=utf-8");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword("zzb200166");
        dataSource.setUsername("root");
        return dataSource;
    }

    @Bean
    public JobDetail jobDetail1(){
        return JobBuilder.newJob(SpringJob.class)
                .withIdentity("springJob1")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger1(){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .startNow()
                .withIdentity("trigger1")
                .forJob("springJob1")
                .build();
    }
    @Bean
    public JobDetail jobDetail2(){
        return JobBuilder.newJob(SpringJob.class)
                .withIdentity("springJob2")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger2(){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .startNow()
                .withIdentity("trigger2")
                .forJob("springJob2")
                .build();
    }
    @Bean
    public JobDetail jobDetail3(){
        return JobBuilder.newJob(SpringJob.class)
                .withIdentity("springJob3")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger3(){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .startNow()
                .withIdentity("trigger3")
                .forJob("springJob3")
                .build();
    }
}
