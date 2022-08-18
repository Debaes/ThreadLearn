package com.dgx.chapter1.stopThread;

import java.util.concurrent.Callable;

/**
 * 没有Sleep的情况下如何中断线程
 * Create by dgx 2022-08-14 13:06
 */
public class RightWayStopThreadWithoutSleep implements Runnable {


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        int num=0;
        while(!Thread.currentThread().isInterrupted() &&num<=Integer.MAX_VALUE/2 ){
            if (num%10000==0){
                System.out.println(num +"是10000的倍数");
            }
            num++;
        }
        System.out.println("结束任务");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread otherThread = new Thread(new RightWayStopThreadWithoutSleep());

        otherThread.start();
        Thread.sleep(2000);
        otherThread.interrupt();
    }
}
