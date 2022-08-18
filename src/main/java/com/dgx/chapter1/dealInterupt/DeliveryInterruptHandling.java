package com.dgx.chapter1.dealInterupt;

/**
 * 终止线程的最佳实践1
 * 传递中断 被调用方应该将中断抛出
 *
 * 如果被调研方没有抛出异常则会
 * Create by dgx 2022-08-14 14:10
 */
public class DeliveryInterruptHandling {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                while (true && !Thread.currentThread().isInterrupted()) {

                        System.out.println("h");
                        CalleeMethod();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
    private static void CalleeMethod() throws InterruptedException {
            Thread.sleep(1000);
    }
}
