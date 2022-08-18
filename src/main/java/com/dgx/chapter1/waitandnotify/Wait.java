package com.dgx.chapter1.waitandnotify;

/**
 * 验证线程
 * Create by dgx 2022-08-14 16:36
 */
public class Wait {

    static Object monitorLock =new Object();
    static  class Thread1  extends Thread{
        @Override
        public void run() {
            synchronized (monitorLock){
                try {
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    monitorLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
            }
        }
    }

    static  class Thread2  extends Thread{
        @Override
        public void run() {
            synchronized (monitorLock){
                monitorLock.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
            new Thread2().start();
            Thread.sleep(1000);
            new Thread1().start();

    }
}
