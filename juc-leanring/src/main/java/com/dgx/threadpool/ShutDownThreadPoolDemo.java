package com.dgx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by dgx 2022-08-27 16:36
 */
public class ShutDownThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i=0;i<1000;i++){
            executorService.execute(()->
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("是否停止"+executorService.isShutdown());
        executorService.shutdown();

        System.out.println("是否停止"+executorService.isShutdown());
        System.out.println("要关闭了");

        System.out.println("线程全部关闭"+executorService.isTerminated());

        System.out.println("完全停止检测 "+executorService.awaitTermination(3, TimeUnit.SECONDS));


        executorService.shutdownNow();
    }
}
