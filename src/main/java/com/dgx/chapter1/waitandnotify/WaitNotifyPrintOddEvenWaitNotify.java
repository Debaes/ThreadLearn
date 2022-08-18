package com.dgx.chapter1.waitandnotify;

/**
 * Create by dgx 2022-08-14 22:06
 */
public class WaitNotifyPrintOddEvenWaitNotify {

    private static Object lock =new Object();
    private static int count=0;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ThreadTurning(),"偶数").start();
        Thread.sleep(50);
        new Thread(new ThreadTurning(),"奇数").start();
    }
    static class ThreadTurning implements  Runnable{
        @Override
        public void run() {

            while (count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();

                    if (count<=100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

