package com.dgx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by dgx 2022-08-27 16:36
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<1000;i++){
            executorService.execute(()->
            {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
