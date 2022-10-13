package com.dgx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Create by dgx 2022-08-27 16:36
 */
public class ScheduleThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

   executorService.scheduleAtFixedRate(()->{
       System.out.println(Thread.currentThread().getName()+"hello");
   },1,3, TimeUnit.SECONDS);
    }
}
