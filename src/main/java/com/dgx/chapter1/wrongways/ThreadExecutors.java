package com.dgx.chapter1.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by dgx 2022-08-14 11:21
 */
public class ThreadExecutors {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i <100 ; i++) {
executorService.submit(()->
        System.out.println("sadsa"));
        }
    }
}
