package com.dgx.chapter1.stage5.deadlock;

/**
 * 描述：     第二章线程安全问题，演示死锁。
 *
 * 1. 持有两把锁
 *
 */
public class DeadLock implements Runnable {

    int flag = 1;


    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        DeadLock r1 = new DeadLock();
        DeadLock r2 = new DeadLock();
        r1.flag = 0;
        r2.flag = 1;
        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }
}
