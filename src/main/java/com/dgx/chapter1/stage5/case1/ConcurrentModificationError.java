package com.dgx.chapter1.stage5.case1;


import com.dgx.chapter1.stage5.skip.MultiThreadsError;

/**
 * 演示 并发修改错误
 */
public class ConcurrentModificationError implements Runnable {

    static ConcurrentModificationError instance = new ConcurrentModificationError();
    int index = 0;

    @Override
    public void run() {

        for (int i=0;i<10000;i++){
            index++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();;
        thread2.start();

        thread1.join();;
        thread2.join();

        System.out.println(instance.index);
    }
}
