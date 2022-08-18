package com.dgx.chapter1.stage5.case1;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示 并发修改错误 统计错误次数
 */
public class ConcurrentModificationErrorCount implements Runnable {

    static ConcurrentModificationErrorCount instance = new ConcurrentModificationErrorCount();
    int index = 0;


    /**
     * 统计正确次数
     */
    static AtomicInteger truelyRuntimes =new AtomicInteger();

    /**
     * 统计错误次数
     */
    static AtomicInteger errorCounter =new AtomicInteger();

    static CyclicBarrier cyclicBarrier =new CyclicBarrier(2);
    static CyclicBarrier cyclicBarrier2 =new CyclicBarrier(2);
    boolean flag[] =new boolean[200000];
    @Override
    public void run() {

        for (int i=0;i<10000;i++){
            try {
                cyclicBarrier2.reset();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            truelyRuntimes.incrementAndGet();
            if (flag[index] &&flag[index-1]){
                System.out.println("发送错误的index: " +index);
                errorCounter.incrementAndGet();
            }
            flag[index]=true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();;
        thread2.start();

        thread1.join();;
        thread2.join();

        System.out.println("******************************");
        System.out.println("表面结果:"+instance.index);
        System.out.println("真正运行次数 :"+truelyRuntimes);
        System.out.println("错误次数 :"+errorCounter);
    }
}
