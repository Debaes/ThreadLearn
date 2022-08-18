package com.dgx.chapter1.dealInterupt;

/**
 * 终止线程的最佳实践2

 被调用方应该在异常出重新中断
 * Create by dgx 2022-08-14 14:10
 */
public class TheCallerShouldReStandardTheException {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
                while (true  ) {
                    // 调用则需要检测
                    if (Thread.currentThread().isInterrupted()){

                        System.out.println("程序被中断");
                        break;
                    }
                        System.out.println("h");
                        CalleeMethod();
                }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
    private static void CalleeMethod()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 调用则需要重新 设置
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
