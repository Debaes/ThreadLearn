package com.dgx.chapter1.waitandnotify;

/**
 * Create by dgx 2022-08-14 22:06
 */
public class WaitNotifyPrintOddEvenSyn {

    private static  Object lock =new Object();
    private static int count=0;

    public static void main(String[] args) {


        new Thread (()->{

            while (count<100){
                synchronized (lock){
                    if ((count&1)==0){
                        System.out.println("偶数"+count);
                        count++;
                    }
                }
            }
        },"偶数").start();



        new Thread (()->{

            while (count<100){
                synchronized (lock){
                    if ((count&1)==1){
                        System.out.println("奇数"+count);
                        count++;
                    }
                }
            }
        },"奇数").start();
    }

}
