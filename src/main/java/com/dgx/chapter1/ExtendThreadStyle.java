package com.dgx.chapter1;

/**
 * Create by dgx 2022-08-14 9:35
 */
public class ExtendThreadStyle extends  Thread {

    @Override
    public void run() {
        System.out.println("Thread 实现多线");
    }

    public static void main(String[] args) {
         new ExtendThreadStyle().start();
    }
}
