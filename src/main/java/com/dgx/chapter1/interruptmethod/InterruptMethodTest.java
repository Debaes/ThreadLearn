package com.dgx.chapter1.interruptmethod;

/**
 * Create by dgx 2022-08-14 15:52
 */
public class InterruptMethodTest {

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            System.out.println("阿斯顿撒");
        });

        threadOne.interrupt();


        System.out.println(threadOne.isInterrupted());

        System.out.println(threadOne.interrupted());

        System.out.println(  Thread.interrupted());
        Thread.currentThread().interrupt();

        Thread.currentThread().isInterrupted();

    }
}
