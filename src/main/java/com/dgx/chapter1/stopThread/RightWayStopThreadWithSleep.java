package com.dgx.chapter1.stopThread;

/**
 * 发送阻塞情况下的  停止线程
 * Create by dgx 2022-08-14 13:06
 */
public class RightWayStopThreadWithSleep implements Runnable {

    @Override
    public void run() {

        int num=0;
        try {
            while(!Thread.currentThread().isInterrupted() &&num<=300 ){
                            if (num%1==0){
                                System.out.println(num +"是10000的倍数");
                            }
                            num++;

                            Thread.sleep(1000);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束任务");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread otherThread = new Thread(new RightWayStopThreadWithSleep());

        otherThread.start();
        Thread.sleep(500);
        otherThread.interrupt();
    }
}
