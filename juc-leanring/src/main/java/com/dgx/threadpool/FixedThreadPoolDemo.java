package com.dgx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by dgx 2022-08-27 16:36
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i=0;i<1000;i++){
            executorService.execute(()->
            {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
