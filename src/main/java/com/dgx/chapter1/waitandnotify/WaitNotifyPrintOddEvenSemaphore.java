package com.dgx.chapter1.waitandnotify;

import java.util.concurrent.Semaphore;

/**
 * Create by dgx 2022-08-14 22:06
 */
public class WaitNotifyPrintOddEvenSemaphore {


   static Semaphore printOdd=new Semaphore(0);
   static Semaphore printEven=new Semaphore(1);

   static int count;
    public static void main(String[] args) throws InterruptedException {

      new Thread(()->{
        while (count<100){

              try {
                  printEven.acquire();
                  System.out.println(Thread.currentThread().getName()+":"+count++);
                  printOdd.release();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

          }
      },"偶数").start();


        new Thread(()->{
            while (count<100){

                try {
                    printOdd.acquire();
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    printEven.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"奇数").start();
    }



}

